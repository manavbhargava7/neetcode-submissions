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
        //need to traverse both trees and check that the values are equivalent
        return equalsNode(p, q);
    }

    private boolean equalsNode(TreeNode p, TreeNode q) {
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        } 
        if (p == null && q == null) {
            return true;
        }

        return p.val == q.val && equalsNode(p.left, q.left) && equalsNode(p.right, q.right);
    }
}
