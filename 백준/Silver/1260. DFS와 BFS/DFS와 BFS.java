import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  static ArrayList<Integer>[] graph;
  static boolean[] visited;
  static int N, M, V;
  static int MAX = 1000 + 10;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    V = Integer.parseInt(st.nextToken());

    graph = new ArrayList[MAX];
    visited = new boolean[MAX];

    for (int i = 1; i <= N; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      StringTokenizer st1 = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st1.nextToken());
      int y = Integer.parseInt(st1.nextToken());
      graph[x].add(y);
      graph[y].add(x);
    }

    for (int i = 1; i <= N; i++) {
      Collections.sort(graph[i]);
    }

    dfs(V);


    visited = new boolean[MAX];

    sb.append("\n");

    bfs(V);

    System.out.println(sb);
  }

  private static void bfs(int v) {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(v);
    visited[v] = true;

    while (!queue.isEmpty()) {
      Integer current = queue.poll();
      sb.append(current).append(" ");
      for (Integer next : graph[current]) {
        if (!visited[next]) {
          queue.offer(next);
          visited[next] = true;
        }
      }
    }
  }

  private static void dfs(int v) {
    visited[v] = true;
    sb.append(v).append(" ");
    for (Integer next : graph[v]) {
      if (!visited[next]) {
        dfs(next);
      }
    }
  }
}