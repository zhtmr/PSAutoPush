import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  static List<List<Integer>> graph;
  static int[] distance;
  static int N, M, K, X;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    X = Integer.parseInt(st.nextToken());

    graph = new ArrayList<>();
    for (int i = 0; i < N + 1; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      graph.get(a).add(b);
    }

    distance = new int[N + 1];
    Arrays.fill(distance, -1);
    distance[X] = 0;

    int[] distance = bfs(X);

    boolean found = false;
    for (int i = 1; i <= N; i++) {
      if (distance[i] == K) {
        System.out.println(i);
        found = true;
      }
    }
    if (!found) {
      System.out.println(-1);
    }
  }

  private static int[] bfs(int x) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(x);

    while (!queue.isEmpty()) {
      int current = queue.poll();

      for (int next : graph.get(current)) {
        if (distance[next] == -1) {
          distance[next] = distance[current] + 1;
          queue.add(next);
        }
      }
    }
    return distance;
  }
}