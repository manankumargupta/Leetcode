class Solution {
    private int[] nums;

    public int[] sortArray(int[] nums) {
        this.nums = nums;
        quickSort(0, nums.length - 1);
        return nums;
    }

    private void quickSort(int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = nums[(left + right) >> 1];
      
        int i = left - 1;
        int j = right + 1;
      
        while (i < j) {
            while (nums[++i] < pivot) {
            }
        
            while (nums[--j] > pivot) {
            }
          
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
      
        quickSort(left, j);
      
        quickSort(j + 1, right);
    }
}
