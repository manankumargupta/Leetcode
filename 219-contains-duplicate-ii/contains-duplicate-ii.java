class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // HashMap to store each number and its most recent index
        Map<Integer, Integer> numToIndexMap = new HashMap<>();
      
        // Iterate through the array
        for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {
            // Get the previous index of the current number (default to a very small value if not found)
            int previousIndex = numToIndexMap.getOrDefault(nums[currentIndex], -1000000);
          
            // Check if the distance between current and previous occurrence is at most k
            if (currentIndex - previousIndex <= k) {
                return true;  // Found duplicate within distance k
            }
          
            // Update the map with the current number and its latest index
            numToIndexMap.put(nums[currentIndex], currentIndex);
        }
      
        // No duplicates found within distance k
        return false;
    }
}
