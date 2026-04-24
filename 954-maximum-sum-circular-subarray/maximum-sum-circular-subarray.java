class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        final int INFINITY = 1 << 30; 
      
        int minPrefixSum = 0; 
        int maxPrefixSum = -INFINITY; 
      
        int maxSubarraySum = -INFINITY;      
        int currentPrefixSum = 0;  
        int minSubarraySum = INFINITY;    
      
        for (int num : nums) {
            currentPrefixSum += num;
          
            maxSubarraySum = Math.max(maxSubarraySum, currentPrefixSum - minPrefixSum);
          
            minSubarraySum = Math.min(minSubarraySum, currentPrefixSum - maxPrefixSum);
          
            minPrefixSum = Math.min(minPrefixSum, currentPrefixSum);
            maxPrefixSum = Math.max(maxPrefixSum, currentPrefixSum);
        }
        return Math.max(maxSubarraySum, currentPrefixSum - minSubarraySum);
    }
}
