import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
  static int[][] graph;
  static boolean[][] visited;
  static int N;
  static int[][] pos = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우
  static int count;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    graph = new int[N][N];
    visited = new boolean[N][N];

    for (int i = 0; i < N; i++) {
      String s = br.readLine();
      for (int j = 0; j < N; j++) {
        graph[i][j] = s.charAt(j) - '0';
      }
    }

    ArrayList<Integer> result = new ArrayList<>();
    // (0,0) 부터 모든 요소에 대해 dfs
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (!visited[i][j] && graph[i][j] == 1) {
          count = 0;
          dfs(i, j);
          result.add(count);
        }
      }
    }

    System.out.println(result.size());
    Collections.sort(result);
    for (Integer integer : result) {
      System.out.println(integer);
    }
  }

  private static void dfs(int x, int y) {
    visited[x][y] = true;
    count++;
    // 상하좌우 탐색
    for (int i = 0; i < pos.length; i++) {
      int nx = x + pos[i][0];
      int ny = y + pos[i][1];

      if (isRange(nx, ny) && !visited[nx][ny] && graph[nx][ny] == 1) {
        dfs(nx, ny);
      }
    }
  }

  private static boolean isRange(int nx, int ny) {
    return nx >= 0 && nx < N && ny >= 0 && ny < N;
  }
}