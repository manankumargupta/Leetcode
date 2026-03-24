class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum);
    }

    private boolean dfs(TreeNode node, int remainingSum) {
        if (node == null) {
            return false;
        }
      
        remainingSum -= node.val;
      
        if (node.left == null && node.right == null && remainingSum == 0) {
            return true;
        }
      
        return dfs(node.left, remainingSum) || dfs(node.right, remainingSum);
    }
}