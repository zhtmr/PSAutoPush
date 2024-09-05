import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int N;
  static int[][] arr;
  static int min = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    arr = new int[N][2];

    for (int i = 0; i < N; i++) {
      String[] split = br.readLine().split(" ");
      arr[i][0] = Integer.parseInt(split[0]);
      arr[i][1] = Integer.parseInt(split[1]);
    }

    findMinGap(0, 1, 0, 0);
    System.out.println(min);
  }

  // 신맛 acidity
  // 쓴맛 acerbity
  private static void findMinGap(int idx, int acidity, int acerbity, int use) {
    if (idx == N) {
      if (use == 0) {
        return;
      }
      int diff = Math.abs(acidity - acerbity);
      min = Math.min(diff, min);
      return;
    }

    findMinGap(idx + 1, acidity * arr[idx][0], acerbity + arr[idx][1], use + 1);
    findMinGap(idx + 1, acidity, acerbity, use);

  }

}