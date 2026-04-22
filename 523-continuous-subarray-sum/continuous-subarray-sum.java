class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> remainderIndexMap = new HashMap<>();
      
        remainderIndexMap.put(0, -1);
      
        int runningSum = 0;
      
        for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {
            runningSum = (runningSum + nums[currentIndex]) % k;
          
            if (!remainderIndexMap.containsKey(runningSum)) {
                remainderIndexMap.put(runningSum, currentIndex);
            } else if (currentIndex - remainderIndexMap.get(runningSum) > 1) {
                return true;
            }
        }
      
        return false;
    }
}