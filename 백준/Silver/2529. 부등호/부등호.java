import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {
  static int[] arr;
  static boolean[] visited = new boolean[10];
  static String[] sign;
  static List<String> result = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int k = Integer.parseInt(br.readLine());

    sign = br.readLine().split(" ");
    arr = new int[k + 1];

    dfs(0);
    System.out.println(result.get(result.size() - 1));
    System.out.println(result.get(0));
  }

  private static void dfs(int depth) {
    if (depth == arr.length) {
      if (isValid()) {
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
          sb.append(num);
        }
        result.add(sb.toString());
      }
      return;
    }
    for (int i = 0; i <= 9; i++) {
      if (!visited[i]) {
        visited[i] = true;
        arr[depth] = i;
        dfs(depth + 1);
        visited[i] = false;
      }
    }
  }

  private static boolean isValid() {
    for (int i = 0; i < sign.length; i++) {
      if (sign[i].equals("<")) {
        if (arr[i] >= arr[i + 1]) {
          return false;
        }
      } else if (sign[i].equals(">")) {
        if (arr[i] <= arr[i + 1]) {
          return false;
        }
      }
    }
    return true;
  }
}