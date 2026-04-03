class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (point1, point2) -> {
            double distance1 = Math.hypot(point1[0], point1[1]);
            double distance2 = Math.hypot(point2[0], point2[1]);
          
            if (distance1 - distance2 > 0) {
                return 1; 
            } else {
                return -1; 
            }
        });
      
        return Arrays.copyOfRange(points, 0, k);
    }
}