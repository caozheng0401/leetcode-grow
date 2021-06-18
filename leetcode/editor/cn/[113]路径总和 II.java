package editor.cn;//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
//
// 叶子节点 是指没有子节点的节点。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：[[5,4,11,2],[5,8,4,5]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,3], targetSum = 5
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], targetSum = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点总数在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
// 
// 
// Related Topics 树 深度优先搜索 
// 👍 499 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
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
    private List<List<Integer>> res = new LinkedList<>();
    private Deque<Integer> path = new LinkedList<>();
    private void list(TreeNode root, int targetSum){
        if (root.left == null && root.right == null && targetSum == 0) {
            res.add(new LinkedList<>(path));
            return ;
        }
        if (root.left == null && root.right == null ) return ;
        if (root.left != null){
            path.offerLast(root.left.val);
            targetSum -= root.left.val;
            list(root.left,targetSum);
            targetSum += root.left.val;
            path.pollLast();

        }
        if (root.right != null){
            path.offerLast(root.right.val);
            targetSum -= root.right.val;
            list(root.right,targetSum);
            targetSum += root.right.val;
            path.pollLast();
        }
        return;
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res.clear();
        path.clear();
        if (root == null) {
            return res;
        }
        path.add(root.val);
        targetSum -= root.val;
        list(root, targetSum);
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
