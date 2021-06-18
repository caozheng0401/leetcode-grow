//给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索 
// 👍 513 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

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
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<String> res = new ArrayList<>();
        list(root,temp,res);
        return res;
    }
    private void list(TreeNode node, List<Integer> path, List<String> res){
        path.add(node.val);
        if (node.left == null && node.right == null){
            int size = path.size();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < size -1; i++) {
                stringBuilder.append(path.get(i) + "->");
            }
            stringBuilder.append(path.get(size -1));
            res.add(stringBuilder.toString());
            return;
        }
        if (node.left != null) {
            list(node.left, path, res);
            path.remove(path.size() -1);
        }
        if (node.right != null) {
            list(node.right, path, res);
            path.remove(path.size() -1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
