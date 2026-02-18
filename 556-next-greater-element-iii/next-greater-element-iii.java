class Solution {
    public int nextGreaterElement(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        int length = digits.length;
      
        int pivotIndex = length - 2;
        while (pivotIndex >= 0 && digits[pivotIndex] >= digits[pivotIndex + 1]) {
            pivotIndex--;
        }
      
        if (pivotIndex < 0) {
            return -1;
        }
      
        int swapIndex = length - 1;
        while (digits[pivotIndex] >= digits[swapIndex]) {
            swapIndex--;
        }
        swap(digits, pivotIndex, swapIndex);
      
        reverse(digits, pivotIndex + 1, length - 1);
        long result = Long.parseLong(String.valueOf(digits));
        return result > Integer.MAX_VALUE ? -1 : (int) result;
    }
  
    private void swap(char[] digits, int i, int j) {
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
    }
  
    private void reverse(char[] digits, int start, int end) {
        while (start < end) {
            swap(digits, start, end);
            start++;
            end--;
        }
    }
}