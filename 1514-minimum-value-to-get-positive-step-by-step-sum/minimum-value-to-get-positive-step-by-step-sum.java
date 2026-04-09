class Solution {
    public int minStartValue(int[] nums) {
        int runningSum = 0;
      
        int minPrefixSum = Integer.MAX_VALUE;
      
        for (int num : nums) {
            runningSum += num;
          
            minPrefixSum = Math.min(minPrefixSum, runningSum);
        }
        return Math.max(1, 1 - minPrefixSum);
    }
}
