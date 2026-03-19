class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == rightNode) {
            return true;
        }
      
        if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
            return false;
        }
      
        return isMirror(leftNode.left, rightNode.right) && 
               isMirror(leftNode.right, rightNode.left);
    }
}