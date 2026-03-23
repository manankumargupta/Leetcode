class Solution {
    private Map<Integer, Integer> inorderIndexMap = new HashMap<>();
  
    private int[] postorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        int arrayLength = inorder.length;
      
        for (int i = 0; i < arrayLength; ++i) {
            inorderIndexMap.put(inorder[i], i);
        }
      
        return buildSubtree(0, 0, arrayLength);
    }

    private TreeNode buildSubtree(int inorderStart, int postorderStart, int subtreeSize) {
        if (subtreeSize <= 0) {
            return null;
        }
      
        int rootValue = postorder[postorderStart + subtreeSize - 1];
      
        int rootIndexInorder = inorderIndexMap.get(rootValue);
      
        int leftSubtreeSize = rootIndexInorder - inorderStart;
      
        TreeNode leftChild = buildSubtree(inorderStart, postorderStart, leftSubtreeSize);
      
        TreeNode rightChild = buildSubtree(rootIndexInorder + 1, 
                                          postorderStart + leftSubtreeSize, 
                                          subtreeSize - leftSubtreeSize - 1);
      
        return new TreeNode(rootValue, leftChild, rightChild);
    }
}