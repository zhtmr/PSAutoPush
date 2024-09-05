import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
  static int N;
  static ArrayList<int[]> arr;
  static int mp, mf, ms, mv;
  static int min = Integer.MAX_VALUE;
  static ArrayList<Integer> result = new ArrayList<>();
  static ArrayList<Integer> tmpResult = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    arr = new ArrayList<>();

    String[] split = br.readLine().split(" ");
    mp = Integer.parseInt(split[0]);
    mf = Integer.parseInt(split[1]);
    ms = Integer.parseInt(split[2]);
    mv = Integer.parseInt(split[3]);

    for (int i = 0; i < N; i++) {
      String[] nutrient = br.readLine().split(" ");
      arr.add(new int[] {Integer.parseInt(nutrient[0]), Integer.parseInt(nutrient[1]),
          Integer.parseInt(nutrient[2]), Integer.parseInt(nutrient[3]),
          Integer.parseInt(nutrient[4])});
    }

    dfs(0, 0, 0, 0, 0, 0);

    if (min == Integer.MAX_VALUE) {
      System.out.println(-1);
    } else {
      System.out.println(min);
      for (Integer i : result) {
        System.out.print(i + " ");
      }
    }
  }

  private static void dfs(int idx, int p, int f, int s, int v, int c) {
    if (p >= mp && f >= mf && s >= ms && v >= mv) {
      if (c < min) {
        min = c;
        result = new ArrayList<>(tmpResult);
        return;
      }
    }

    if (idx == N) {
      return;
    }

    tmpResult.add(idx + 1);
    dfs(idx + 1, p + arr.get(idx)[0], f + arr.get(idx)[1], s + arr.get(idx)[2], v + arr.get(idx)[3],
        c + arr.get(idx)[4]);
    tmpResult.remove(tmpResult.size() - 1);  // 백트래킹

    dfs(idx + 1, p, f, s, v, c);
  }

}