import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[][] graph;
  static boolean[][] visited;
  static int w = -1, h = -1;
  static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
  static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();


    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      w = Integer.parseInt(st.nextToken());
      h = Integer.parseInt(st.nextToken());

      if (w == 0 && h == 0) {
        break;
      }

      buildGraph(w, h, br);

      int count = 0;
      for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
          if (!visited[i][j] && graph[i][j] == 1) {
            dfs(i, j);
            count++;
          }
        }
      }
      sb.append(count).append("\n");
    }

    System.out.println(sb);


  }

  private static void dfs(int i, int j) {
    visited[i][j] = true;

    for (int k = 0; k < 8; k++) {
      int nx = i + dx[k];
      int ny = j + dy[k];

      if (isInRange(nx, ny) && !visited[nx][ny] && graph[nx][ny] == 1) {
        dfs(nx, ny);
      }
    }
  }

  private static void buildGraph(int w, int h, BufferedReader br) throws IOException {
    StringTokenizer st;
    graph = new int[h][w];
    visited = new boolean[h][w];

    for (int i = 0; i < h; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < w; j++) {
        graph[i][j] = Integer.parseInt(st.nextToken());
      }
    }
  }

  private static boolean isInRange(int x, int y) {
    return x >= 0 && x < h && y >= 0 && y < w;
  }
}