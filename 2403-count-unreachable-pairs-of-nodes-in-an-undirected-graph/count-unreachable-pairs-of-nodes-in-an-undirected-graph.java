class Solution {
    private List<Integer>[] graph;
    private boolean[] visited;

    public long countPairs(int n, int[][] edges) {
        graph = new List[n];
        visited = new boolean[n];
      
        Arrays.setAll(graph, i -> new ArrayList<>());
      
        for (int[] edge : edges) {
            int nodeA = edge[0];
            int nodeB = edge[1];
            graph[nodeA].add(nodeB);
            graph[nodeB].add(nodeA);
        }
      
        long totalUnreachablePairs = 0;
        long processedNodes = 0;
      
        for (int i = 0; i < n; ++i) {
            int componentSize = dfs(i);
          
            totalUnreachablePairs += processedNodes * componentSize;
          
            processedNodes += componentSize;
        }
      
        return totalUnreachablePairs;
    }

    private int dfs(int node) {
        if (visited[node]) {
            return 0;
        }
      
        visited[node] = true;
      
        int componentNodeCount = 1;
      
        for (int neighbor : graph[node]) {
            componentNodeCount += dfs(neighbor);
        }
      
        return componentNodeCount;
    }
}