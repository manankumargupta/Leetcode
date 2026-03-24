class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public TreeNode canMerge(List<TreeNode> trees) {
        Map<Integer, TreeNode> valToNode = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();

        for (TreeNode tree : trees) {
            valToNode.put(tree.val, tree);
            count.put(tree.val, count.getOrDefault(tree.val, 0) + 1);
            if (tree.left != null)
                count.put(tree.left.val, count.getOrDefault(tree.left.val, 0) + 1);
            if (tree.right != null)
                count.put(tree.right.val, count.getOrDefault(tree.right.val, 0) + 1);
        }

        for (TreeNode tree : trees)
            if (count.get(tree.val) == 1) {
                if (isValidBST(tree, null, null, valToNode) && valToNode.size() <= 1)
                    return tree;
                return null;
            }

        return null;
    }

    private boolean isValidBST(TreeNode tree, TreeNode minNode, TreeNode maxNode, Map<Integer, TreeNode> valToNode) {
        if (tree == null)
            return true;
        if (minNode != null && tree.val <= minNode.val)
            return false;
        if (maxNode != null && tree.val >= maxNode.val)
            return false;
        if (tree.left == null && tree.right == null && valToNode.containsKey(tree.val)) {
            int val = tree.val;
            tree.left = valToNode.get(val).left;
            tree.right = valToNode.get(val).right;
            valToNode.remove(val);
        }

        return isValidBST(tree.left, minNode, tree, valToNode) &&
               isValidBST(tree.right, tree, maxNode, valToNode);
    }
}