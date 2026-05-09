class Solution {
    private int[][][] dp;
    private int[] boxes;

    public int removeBoxes(int[] boxes) {
        this.boxes = boxes;
        int n = boxes.length;
        dp = new int[n][n][n];
        return calculateMaxPoints(0, n - 1, 0);
    }
    private int calculateMaxPoints(int left, int right, int extraCount) {
        if (left > right) {
            return 0;
        }
      
        while (left < right && boxes[right] == boxes[right - 1]) {
            right--;
            extraCount++;
        }
        if (dp[left][right][extraCount] > 0) {
            return dp[left][right][extraCount];
        }
      
        int maxPoints = calculateMaxPoints(left, right - 1, 0) + 
                        (extraCount + 1) * (extraCount + 1);
        for (int mid = left; mid < right; mid++) {
            if (boxes[mid] == boxes[right]) {
                int points = calculateMaxPoints(mid + 1, right - 1, 0) + 
                            calculateMaxPoints(left, mid, extraCount + 1);
                maxPoints = Math.max(maxPoints, points);
            }
        }
      
        dp[left][right][extraCount] = maxPoints;
        return maxPoints;
    }
}
