import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
  static int[][] graph = new int[5][5];
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
  static Set<String> unique = new HashSet<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    for (int i = 0; i < 5; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 5; j++) {
        graph[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        dfs(i, j, 0, "");
      }
    }

    System.out.println(unique.size());

  }

  private static void dfs(int x, int y, int depth, String digit) {
    if (depth == 6) {
      unique.add(digit);
      return;
    }

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (isInRange(nx, ny)) {
        dfs(nx, ny, depth + 1, digit + graph[nx][ny]);
      }
    }
  }

  private static boolean isInRange(int x, int y) {
    return x >= 0 && x < 5 && y >= 0 && y < 5;
  }
}