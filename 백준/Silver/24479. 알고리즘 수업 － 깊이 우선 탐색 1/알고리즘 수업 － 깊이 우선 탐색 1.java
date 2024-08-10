import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
  static int MAX = 100000 + 10;
  static int N, M, R;
  static ArrayList<Integer>[] graph;
  static boolean[] visited;
  static int[] answer;
  static int order;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());

    graph = new ArrayList[MAX];
    visited = new boolean[MAX];
    answer = new int[MAX];
    order = 1;

    for (int i = 1; i <= N; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      StringTokenizer st1 = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st1.nextToken());
      int v = Integer.parseInt(st1.nextToken());

      graph[u].add(v);
      graph[v].add(u);
    }

    for (int i = 1; i <= N; i++) {
      Collections.sort(graph[i]);
    }

    dfs(R);

    for (int i = 1; i <= N; i++) {
      System.out.println(answer[i]);
    }
  }

  private static void dfs(int r) {
    visited[r] = true;
    answer[r] = order;
    order++;

    for (Integer next : graph[r]) {
      if (!visited[next]) {
        dfs(next);
      }
    }

  }
}