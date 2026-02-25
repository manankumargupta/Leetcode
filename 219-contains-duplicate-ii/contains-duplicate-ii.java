class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> numToIndexMap = new HashMap<>();
      
        for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {
            int previousIndex = numToIndexMap.getOrDefault(nums[currentIndex], -1000000);
          
            if (currentIndex - previousIndex <= k) {
                return true;
            }
          
            numToIndexMap.put(nums[currentIndex], currentIndex);
        }
      
        return false;
    }
}
