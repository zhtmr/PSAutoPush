import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int[][] graph;
  static boolean[][] visited;
  static int N, M;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
  static int count;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    graph = new int[N + 2][M + 2];
    visited = new boolean[N + 2][M + 2];

    for (int i = 1; i <= N; i++) {
      String[] split = br.readLine().split("");
      for (int j = 1; j <= M; j++) {
        graph[i][j] = Integer.parseInt(split[j - 1]);
      }
    }

    bfs();
    System.out.println(count);
  }

  private static void bfs() {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[] {1, 1, 1});
    visited[1][1] = true;

    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int cx = current[0];
      int cy = current[1];
      int depth = current[2];

      if (cx == N && cy == M) {
        count = depth;
        return;
      }

      for (int i = 0; i < 4; i++) {
        int nx = cx + dx[i];
        int ny = cy + dy[i];

        if (!visited[nx][ny] && graph[nx][ny] != 0) {
          queue.add(new int[] {nx, ny, depth + 1});
          visited[nx][ny] = true;
        }
      }
    }

  }
}