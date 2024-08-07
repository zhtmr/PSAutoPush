import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
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

    System.out.println(bfs(p1, p2));
  }

  private static int bfs(int p1, int p2) {
    LinkedList<int[]> queue = new LinkedList<>();
    queue.add(new int[] {p1, 0});
    visited[p1] = true;

    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int node = current[0];
      int depth = current[1];

      if (node == p2) {
        return depth;
      }

      for (int i = 1; i <= n; i++) {
        if (!visited[i] && graph[node][i]) {
          visited[i] = true;
          queue.add(new int[] {i, depth + 1});
        }
      }
    }
    return answer;
  }
}