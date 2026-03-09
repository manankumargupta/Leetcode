class Solution {
    private long[] powerOfBase;
    private long[] prefixHash;
  
    public String longestPrefix(String s) {
        final int BASE = 131;
        int n = s.length();
      
        powerOfBase = new long[n + 10];
        prefixHash = new long[n + 10];
      
        powerOfBase[0] = 1;
      
        for (int i = 0; i < n; i++) {
            powerOfBase[i + 1] = powerOfBase[i] * BASE;
          
            prefixHash[i + 1] = prefixHash[i] * BASE + s.charAt(i);
        }
      
        for (int length = n - 1; length > 0; length--) {
            if (getSubstringHash(1, length) == getSubstringHash(n - length + 1, n)) {
                return s.substring(0, length);
            }
        }
      
        return "";
    }
  
    private long getSubstringHash(int left, int right) {
        return prefixHash[right] - prefixHash[left - 1] * powerOfBase[right - left + 1];
    }
}