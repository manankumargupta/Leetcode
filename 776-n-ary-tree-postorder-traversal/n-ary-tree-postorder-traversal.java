class Solution {
    private List<Integer> result = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        performPostorderTraversal(root);
        return result;
    }

    private void performPostorderTraversal(Node node) {
        if (node == null) {
            return;
        }
      
        for (Node child : node.children) {
            performPostorderTraversal(child);
        }
      
        result.add(node.val);
    }
}