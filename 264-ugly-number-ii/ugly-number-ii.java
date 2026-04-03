class Solution {
    public int nthUglyNumber(int n) {
        Set<Long> visitedNumbers = new HashSet<>();
      
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
      
        int[] primeFactors = new int[] {2, 3, 5};
      
        minHeap.offer(1L);
        visitedNumbers.add(1L);
      
        long currentUglyNumber = 0;
      
        while (n-- > 0) {
            currentUglyNumber = minHeap.poll();
          
            for (int factor : primeFactors) {
                long nextUglyNumber = currentUglyNumber * factor;
              
                if (visitedNumbers.add(nextUglyNumber)) {
                    minHeap.offer(nextUglyNumber);
                }
            }
        }
      
        return (int) currentUglyNumber;
    }
}