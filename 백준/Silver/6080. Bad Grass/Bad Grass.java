import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[][] graph;
  static boolean[][] visited;
  static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
  static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
  static int R, C, answer;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    graph = new int[R][C];
    visited = new boolean[R][C];

    for (int i = 0; i < R; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < C; j++) {
        graph[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (!visited[i][j] && graph[i][j] != 0) {
          dfs(i, j);
          answer++;
        }
      }
    }

    System.out.println(answer);
  }

  private static void dfs(int i, int j) {
    visited[i][j] = true;

    for (int k = 0; k < 8; k++) {
      int nx = i + dx[k];
      int ny = j + dy[k];

      if (isInRange(nx, ny) && !visited[nx][ny] && graph[nx][ny] != 0) {
        dfs(nx, ny);
      }
    }
  }

  private static boolean isInRange(int x, int y) {
    return x >= 0 && x < R && y >= 0 && y < C;
  }
}