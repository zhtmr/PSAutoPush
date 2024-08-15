import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
  static int[] limit;
  static boolean[] possible;
  static boolean[][][] visited;

  static class State {
    int[] x;

    public State(int[] x) {
      this.x = new int[3];
      for (int i = 0; i < 3; i++) {
        this.x[i] = x[i];
      }
    }

    State move(int from, int to, int[] limit) {
      int[] nx = new int[] {x[0], x[1], x[2]};
      if (x[from] + x[to] >= limit[to]) {
        nx[from] -= limit[to] - x[to];
        nx[to] = limit[to];
      } else {
        nx[to] += nx[from];
        nx[from] = 0;
      }
      return new State(nx);
    }
  }


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    limit = new int[3];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 3; i++) {
      limit[i] = Integer.parseInt(st.nextToken());
    }
    possible = new boolean[201];
    visited = new boolean[201][201][201];

    bfs(0, 0, limit[2]);
    for (int i = 0; i <= limit[2]; i++) {
      if (possible[i]) {
        sb.append(i).append(" ");
      }
    }
    System.out.println(sb);

  }

  private static void bfs(int a, int b, int c) {
    LinkedList<State> queue = new LinkedList<>();
    visited[a][b][c] = true;
    queue.add(new State(new int[] {a, b, c}));

    while (!queue.isEmpty()) {
      State current = queue.poll();
      int curA = current.x[0];
      int curB = current.x[1];
      int curC = current.x[2];

      if (curA == 0) {
        possible[curC] = true;
      }

      for (int from = 0; from < 3; from++) {
        for (int to = 0; to < 3; to++) {
          if (from == to) continue;
          State next = current.move(from, to, limit);
          if (!visited[next.x[0]][next.x[1]][next.x[2]]) {
            visited[next.x[0]][next.x[1]][next.x[2]] = true;
            queue.add(next);
          }
        }
      }
    }
  }

}