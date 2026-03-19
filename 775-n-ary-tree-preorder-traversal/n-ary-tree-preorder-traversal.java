class Solution {
    private List<Integer> result = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        dfs(root);
        return result;
    }

    private void dfs(Node node) {
        if (node == null) {
            return;
        }
      
        result.add(node.val);
      
        for (Node child : node.children) {
            dfs(child);
        }
    }
}