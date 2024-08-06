import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static boolean[][] graph;
  static boolean[] visited;
  static int answer;
  static int N, M;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());

    graph = new boolean[N + 1][N + 1];
    visited = new boolean[N + 1];

    int x, y;
    for (int i = 0; i < M; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      x = Integer.parseInt(st.nextToken());
      y = Integer.parseInt(st.nextToken());
      graph[x][y] = true;
      graph[y][x] = true;
    }

    dfs(1);
    System.out.println(answer - 1);

    br.close();
  }

  private static void dfs(int i) {
    visited[i] = true;
    answer++;

    for (int j = 1; j <= N; j++) {
      if (!visited[j] && graph[i][j]) {
        dfs(j);
      }
    }

  }

}