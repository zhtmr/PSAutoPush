import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[] arr;
  static int count = 0;
  static int n;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    arr = new int[n];
    visited = new boolean[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int s = Integer.parseInt(br.readLine());
    dfs(s - 1);

    System.out.println(count);
  }

  private static void dfs(int index) {
    if (visited[index]) {
      return;
    }
    visited[index] = true;
    count++;
    int left = index - arr[index];
    int right = index + arr[index];

    if (isInRange(left)) {
      dfs(left);
    }
    if (isInRange(right)) {
      dfs(right);
    }
  }

  private static boolean isInRange(int index) {
    return index >= 0 && index < n;
  }
}