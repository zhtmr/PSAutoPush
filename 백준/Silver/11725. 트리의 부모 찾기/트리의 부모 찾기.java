import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  static ArrayList<Integer>[] graph;
  static boolean[] visited;
  static int N;
  static int MAX = 100000 + 10;
  static int[] answer;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    graph = new ArrayList[MAX];
    visited = new boolean[MAX];
    answer = new int[MAX];

    for (int i = 1; i <= N; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 1; i <= N - 1; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      graph[x].add(y);
      graph[y].add(x);
    }

    dfs(1);

    for (int i = 2; i <= N; i++) {
      System.out.println(answer[i]);
    }
  }

  private static void dfs(int i) {
    visited[i] = true;


    for (Integer next : graph[i]) {
      if (!visited[next]) {
        answer[next] = i;
        dfs(next);
      }
    }
  }
}