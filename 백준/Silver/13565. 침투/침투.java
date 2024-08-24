import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[][] graph;
  static boolean[][] visited;
  static int M, N;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
  static boolean flag = false;
  static int MAX = 1000 + 10;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    graph = new int[MAX][MAX];
    visited = new boolean[MAX][MAX];

    for (int i = 0; i < M; i++) {
      String[] split = br.readLine().split("");
      for (int j = 0; j < N; j++) {
        graph[i][j] = Integer.parseInt(split[j]);
      }
    }

    for (int i = 0; i < N; i++) {
      if (graph[M - 1][i] == 0) {
        graph[M - 1][i] = 2;
      }
    }

    for (int i = 0; i < M; i++) {
      if (!visited[0][i] && graph[0][i] != 1) {
        dfs(0, i);
      }
    }

    if (flag) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }

  }

  private static void dfs(int x, int y) {
    if (graph[x][y] == 2) {
      flag = true;
      return;
    }
    visited[x][y] = true;

    for (int k = 0; k < 4; k++) {
      int nx = x + dx[k];
      int ny = y + dy[k];

      if (isInRange(nx, ny) && !visited[nx][ny] && graph[nx][ny] != 1) {
        dfs(nx, ny);
      }
    }
  }

  private static boolean isInRange(int i, int j) {
    return i >= 0 && i < M && j >= 0 && j < N;
  }

}