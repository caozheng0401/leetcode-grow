package 树;

import javax.xml.soap.Node;

/**
 * url:https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class _226翻转二叉树 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public TreeNode invertTree(TreeNode root) {

        TreeNode a = root.left;
        root.left = root.right;
        root.right = a;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
