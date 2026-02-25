class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
      
        int[] frequencyCount = new int[101];
        for (int i = 0; i < k; i++) {
            frequencyCount[nums[i] + 50]++;
        }
      
        int[] result = new int[n - k + 1];
      
        result[0] = findXthSmallestNegative(frequencyCount, x);
        int resultIndex = 1;
        for (int windowEnd = k; windowEnd < n; windowEnd++) {
            frequencyCount[nums[windowEnd] + 50]++;
          
            frequencyCount[nums[windowEnd - k] + 50]--;
          
            result[resultIndex++] = findXthSmallestNegative(frequencyCount, x);
        }
      
        return result;
    }
  
    private int findXthSmallestNegative(int[] frequencyCount, int x) {
        int cumulativeSum = 0;
      
        for (int i = 0; i < 50; i++) {
            cumulativeSum += frequencyCount[i];
          
            if (cumulativeSum >= x) {
                return i - 50;
            }
        }
      
        return 0;
    }
}