class Solution {
    static int[][] graph;
      static boolean[] visited;

      public int solution(int n, int[][] wires) {
        graph = new int[n + 1][n + 1];

        for (int[] wire : wires) {
          graph[wire[0]][wire[1]] = 1;
          graph[wire[1]][wire[0]] = 1;
        }

        int minDiff = Integer.MAX_VALUE;

        for (int[] wire : wires) {
          int u = wire[0];
          int v = wire[1];

          graph[u][v] = 0;
          graph[v][u] = 0;

          visited = new boolean[n + 1];
          int count1 = dfs(1, visited, graph);
          int count2 = n - count1;

          int diff = Math.abs(count1 - count2);
          minDiff = Math.min(minDiff, diff);

          graph[u][v] = 1;
          graph[v][u] = 1;
        }
        return minDiff;
      }

      private int dfs(int node, boolean[] visited, int[][] graph) {
        visited[node] = true;
        int count = 1;

        for (int i = 1; i < graph.length; i++) {
          if (!visited[i] && graph[node][i] == 1) {
            count += dfs(i, visited, graph);
          }
        }
        return count;
      }
}