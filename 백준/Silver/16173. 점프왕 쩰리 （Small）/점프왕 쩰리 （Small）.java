import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
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

    boolean bfs = bfs(0, 0);
    if (bfs) {
      System.out.println("HaruHaru");
    } else {
      System.out.println("Hing");
    }
  }

  private static boolean bfs(int x, int y) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[] {x, y});
    visited[x][y] = true;

    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int cx = current[0];
      int cy = current[1];
      int jump = graph[cx][cy];

      if (jump == -1) {
        return true;
      }

      if (cy + jump < N && !visited[cx][cy + jump]) {
        queue.add(new int[] {cx, cy + jump});
        visited[cx][cy + jump] = true;
      }

      if (cx + jump < N && !visited[cx + jump][cy]) {
        queue.add(new int[] {cx + jump, cy});
        visited[cx + jump][cy] = true;
      }
    }
    return false;
  }
}