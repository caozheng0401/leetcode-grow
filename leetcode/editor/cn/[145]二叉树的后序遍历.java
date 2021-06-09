//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 604 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
//        ArrayList<Integer> integers = new ArrayList<>();
//        list(root,integers);
//        return integers;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        if (root != null) stack.add(root);
        while(!stack.isEmpty()){
            TreeNode pop = stack.peek();
            if (pop != null){
                stack.pop();
                stack.add(pop);
                stack.add(null);
                if (pop.right != null) stack.add(pop.right);
                if (pop.left != null){
                    stack.add(pop.left);

                }
            }else{
                stack.pop();
                TreeNode res = stack.pop();
                result.add(res.val);
            }
        }
        return result;

    }

    private void list(TreeNode root, ArrayList<Integer> integers) {
        if (root == null) return;
        list(root.left,integers);
        list(root.right,integers);
        integers.add(root.val);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
