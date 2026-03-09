class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }

        int haystackLength = haystack.length();
        int needleLength = needle.length();
      
        int haystackPointer = 0;  
        int needlePointer = 0;  
      
        while (haystackPointer < haystackLength) {
            if (haystack.charAt(haystackPointer) == needle.charAt(needlePointer)) {
                if (needleLength == 1) {
                    return haystackPointer;
                }
              
                haystackPointer++;
                needlePointer++;
            } else {
                haystackPointer = haystackPointer - needlePointer + 1;
              
                needlePointer = 0;
            }

            if (needlePointer == needleLength) {
                return haystackPointer - needlePointer;
            }
        }
      
        return -1;
    }
}