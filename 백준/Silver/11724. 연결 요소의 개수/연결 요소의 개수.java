import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static boolean[][] graph;
  static boolean[] visited;
  static int N, M;
  static int count;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    graph = new boolean[N + 1][N + 1];
    visited = new boolean[N + 1];

    int x, y;
    for (int i = 0; i < M; i++) {
      StringTokenizer st1 = new StringTokenizer(br.readLine());
      x = Integer.parseInt(st1.nextToken());
      y = Integer.parseInt(st1.nextToken());
      graph[x][y] = true;
      graph[y][x] = true;
    }

    for (int i = 1; i <= N; i++) {
      if (!visited[i]) {
        dfs(i);
        count++;
      }

    }

    System.out.println(count);
  }

  private static void dfs(int i) {
    visited[i] = true;

    for (int j = 1; j <= N; j++) {
      if (!visited[j] && graph[i][j]) {
        dfs(j);
      }
    }
  }
}