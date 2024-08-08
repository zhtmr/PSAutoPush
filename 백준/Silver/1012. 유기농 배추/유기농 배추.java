import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int M, N, K;
  static boolean[][] graph;
  static boolean[][] visited;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      M = Integer.parseInt(st.nextToken());
      N = Integer.parseInt(st.nextToken());
      K = Integer.parseInt(st.nextToken());

      graph = new boolean[M][N];
      visited = new boolean[M][N];

      for (int j = 0; j < K; j++) {
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st2.nextToken());
        int y = Integer.parseInt(st2.nextToken());
        graph[x][y] = true;
      }

      int count = 0;
      for (int x = 0; x < M; x++) {
        for (int y = 0; y < N; y++) {
          if (!visited[x][y] && graph[x][y]) {
            dfs(x, y);
            count++;
          }
        }
      }

      System.out.println(count);
    }

  }

  private static void dfs(int x, int y) {
    visited[x][y] = true;

    for (int k = 0; k < 4; k++) {
      int nx = x + dx[k];
      int ny = y + dy[k];

      if (isInRange(nx, ny) && !visited[nx][ny] && graph[nx][ny]) {
        dfs(nx, ny);
      }
    }
  }

  private static boolean isInRange(int nx, int ny) {
    return nx >= 0 && nx < M && ny >= 0 && ny < N;
  }
}