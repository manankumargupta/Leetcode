class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int totalBoomerangs = 0;
      
        for (int[] centerPoint : points) {
            Map<Integer, Integer> distanceCount = new HashMap<>();
          
            for (int[] targetPoint : points) {
                int squaredDistance = (centerPoint[0] - targetPoint[0]) * (centerPoint[0] - targetPoint[0]) + 
                                     (centerPoint[1] - targetPoint[1]) * (centerPoint[1] - targetPoint[1]);
              
                totalBoomerangs += distanceCount.getOrDefault(squaredDistance, 0);
              
                distanceCount.merge(squaredDistance, 1, Integer::sum);
            }
        }
      
        return totalBoomerangs << 1;
    }
}