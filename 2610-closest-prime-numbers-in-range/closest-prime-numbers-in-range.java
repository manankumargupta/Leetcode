import java.util.*;

class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true);

        if (right >= 0) isPrime[0] = false;
        if (right >= 1) isPrime[1] = false;

        // Sieve of Eratosthenes
        for (int i = 2; i * i <= right; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= right; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int prev = -1;
        int minDiff = Integer.MAX_VALUE;
        int[] result = {-1, -1};

        for (int i = left; i <= right; i++) {
            if (isPrime[i]) {
                if (prev != -1 && i - prev < minDiff) {
                    minDiff = i - prev;
                    result[0] = prev;
                    result[1] = i;
                }
                prev = i;
            }
        }

        return result;
    }
}