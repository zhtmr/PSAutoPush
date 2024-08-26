import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[][] graph;
  static boolean[][] visited;
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    graph = new int[N][N];
    visited = new boolean[N][N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        graph[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    boolean dfs = dfs(0, 0);
    if (dfs) {
      System.out.println("HaruHaru");
    } else {
      System.out.println("Hing");
    }
  }

  private static boolean dfs(int x, int y) {
    visited[x][y] = true;
    int jump = graph[x][y];

    if (jump == -1) {
      return true;
    }

    if (y + jump < N && !visited[x][y + jump]) {
      if (dfs(x, y + jump)) {
        return true;
      }
    }

    if (x + jump < N && !visited[x + jump][y]) {
      if (dfs(x + jump, y)){
        return true;
      }
    }
    return false;
  }
}