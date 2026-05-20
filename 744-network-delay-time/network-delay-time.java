class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] graph = new int[n][n];
        int[] distances = new int[n];
        final int INFINITY = 1 << 29;
      
        Arrays.fill(distances, INFINITY);
      
        for (int[] row : graph) {
            Arrays.fill(row, INFINITY);
        }
      
        for (int[] edge : times) {
            int source = edge[0] - 1;
            int target = edge[1] - 1;
            int weight = edge[2];
            graph[source][target] = weight;
        }
        distances[k - 1] = 0;
      
        boolean[] visited = new boolean[n];
      
        for (int i = 0; i < n; i++) {
            int minNode = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (minNode == -1 || distances[minNode] > distances[j])) {
                    minNode = j;
                }
            }
          
            visited[minNode] = true;
          
            for (int j = 0; j < n; j++) {
                distances[j] = Math.min(distances[j], distances[minNode] + graph[minNode][j]);
            }
        }
      
        int maxDistance = 0;
        for (int distance : distances) {
            maxDistance = Math.max(maxDistance, distance);
        }
      
        return maxDistance == INFINITY ? -1 : maxDistance;
    }
}