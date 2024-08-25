import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    visited = new boolean[N + 1];
    System.out.println(bfs(N));
  }

  private static int bfs(int num) {
    LinkedList<int[]> queue = new LinkedList<>();
    queue.add(new int[] {num, 0});
    visited[num] = true;

    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int n = current[0];
      int count = current[1];

      if (n == 1) {
        return count;
      }

      if (n % 3 == 0 && !visited[n / 3]) {
        int q = n / 3;
        queue.add(new int[] {q, count + 1});
        visited[q] = true;
      }
      if (n % 2 == 0 && !visited[n / 2]) {
        int q = n / 2;
        queue.add(new int[] {q, count + 1});
        visited[q] = true;
      }
      if (!visited[n - 1]) {
        queue.add(new int[] {n - 1, count + 1});
        visited[n - 1] = true;
      }
    }
    return -1;
  }
}