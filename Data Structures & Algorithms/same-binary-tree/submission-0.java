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
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p == null && q == null) return true;
        if(p == null && q!= null || p!=null && q==null) return false;

        Queue<TreeNode> q1 = new ArrayDeque<>();
        Queue<TreeNode> q2 = new ArrayDeque<>();
        
        q1.add(p);
        q2.add(q);

        while(!q1.isEmpty() && !q2.isEmpty()) {
            int s1 = q1.size();
            int s2 = q2.size();

            if(s1 != s2) return false;

            for(int i=0;i<s1;i++) {
                TreeNode n1 = q1.poll();
                TreeNode n2 = q2.poll();
                System.out.println(n1.val + " | " + n2.val);
                System.out.println(n1.val == n2.val);
                if(n1.val != n2.val) return false;

                if(n1.left == null && n2.left != null) return false;
                if(n1.left != null && n2.left == null) return false;
                if(n1.right == null && n2.right != null) return false;
                if(n1.right != null && n2.right == null) return false;                

                if(n1.left!=null) q1.add(n1.left);
                if(n1.right!=null) q1.add(n1.right);
                if(n2.left!=null) q2.add(n2.left);
                if(n2.right!=null) q2.add(n2.right);
            }
        }

        return q1.isEmpty() && q2.isEmpty();
    }
}
