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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int leftHeight = depth(root.left);
        int rightHeight = depth(root.right);
        int d = leftHeight + rightHeight;
        int sub = Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));

        return Math.max(d, sub);
    }

    private int depth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
