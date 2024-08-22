import java.util.*;

class Solution {
      static String[][] graph;
      static boolean[][] visited;
      static int n;
      static int[] dx = {-1, 1, 0, 0};
      static int[] dy = {0, 0, -1, 1};
      static ArrayList<Integer> answer = new ArrayList<>();;

      public int[] solution(String[] maps) {
        n = maps.length;
        graph = new String[n][];
        visited = new boolean[n][];

        for (int i = 0; i < n; i++) {
          graph[i] = new String[maps[i].length()];
          visited[i] = new boolean[maps[i].length()];
          char[] charArray = maps[i].toCharArray();
          for (int j = 0; j < charArray.length; j++) {
            graph[i][j] = String.valueOf(charArray[j]);
          }
        }

        for (int x = 0; x < n; x++) {
          for (int y = 0; y < graph[x].length; y++) {
            if (!visited[x][y] && !graph[x][y].equals("X")) {
              answer.add(dfs(x, y));
            }
          }
        }

        if (answer.isEmpty()) {
          return new int[] {-1};
        }

        

        return answer.stream().mapToInt(Integer::intValue).sorted().toArray();
      }

      private static int dfs(int x, int y) {
        visited[x][y] = true;
        int size = Integer.parseInt(graph[x][y]);

        for (int i = 0; i < 4; i++) {
          int nx = x + dx[i];
          int ny = y + dy[i];

          if (isInRange(nx, ny) && !visited[nx][ny] && !graph[nx][ny].equals("X")) {
            size += dfs(nx, ny);
          }
        }
        return size;
      }

      private static boolean isInRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < graph[x].length;
      }
}