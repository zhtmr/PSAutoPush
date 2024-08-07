import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static boolean[][] graph;
  static boolean[] visited;
  static int answer = -1;
  static int n, m;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());

    graph = new boolean[n + 1][n + 1];
    visited = new boolean[n + 1];

    StringTokenizer st = new StringTokenizer(br.readLine());
    int p1 = Integer.parseInt(st.nextToken());
    int p2 = Integer.parseInt(st.nextToken());

    m = Integer.parseInt(br.readLine());
    int x, y;
    for (int i = 0; i < m; i++) {
      StringTokenizer kinship = new StringTokenizer(br.readLine());
      x = Integer.parseInt(kinship.nextToken());
      y = Integer.parseInt(kinship.nextToken());
      graph[x][y] = true;
      graph[y][x] = true;
    }


    dfs(p1, p2, 0);
    System.out.println(answer);
  }

  private static void dfs(int p1, int p2, int depth) {
    if (p1 == p2) {
      answer = depth;
      return;
    }
    visited[p1] = true;

    for (int j = 1; j <= n; j++) {
      if (!visited[j] && graph[p1][j]) {
        dfs(j, p2, depth + 1);
      }
    }
  }
}