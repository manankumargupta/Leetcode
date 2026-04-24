class Solution {
    private int[][] image;    
    private int originalColor;      
    private int newColor;      
  
    private final int[] directions = {-1, 0, 1, 0, -1};
  
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        originalColor = image[sr][sc];
      
        if (originalColor == color) {
            return image;
        }
      
        this.image = image;
        this.newColor = color;
      
        dfs(sr, sc);
      
        return image;
    }
  
    private void dfs(int row, int col) {
        image[row][col] = newColor;
      
        for (int k = 0; k < 4; k++) {
            int nextRow = row + directions[k];
            int nextCol = col + directions[k + 1];
          
            if (nextRow >= 0 && nextRow < image.length && 
                nextCol >= 0 && nextCol < image[0].length && 
                image[nextRow][nextCol] == originalColor) {
                dfs(nextRow, nextCol);
            }
        }
    }
}