class Solution {
    public int repeatedStringMatch(String a, String b) {
        int lengthA = a.length();
        int lengthB = b.length();
      
        int minRepetitions = (lengthB + lengthA - 1) / lengthA;
      
        StringBuilder repeatedString = new StringBuilder(a.repeat(minRepetitions));
      
        for (int additionalAttempts = 0; additionalAttempts < 3; additionalAttempts++) {
            if (repeatedString.toString().contains(b)) {
                return minRepetitions;
            }
          
            minRepetitions++;
            repeatedString.append(a);
        }

        return -1;
    }
}