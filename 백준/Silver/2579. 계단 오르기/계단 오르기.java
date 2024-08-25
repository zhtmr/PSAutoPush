import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] dp = new int[301];
    int[] stairs = new int[301];
    for (int i = 1; i <= N; i++) {
      stairs[i] = Integer.parseInt(br.readLine());
    }

    // dp[i] : i 번째 계단 까지의 최대값
    dp[1] = stairs[1];
    dp[2] = stairs[1] + stairs[2];
    dp[3] = Math.max(stairs[1] + stairs[3], stairs[2] + stairs[3]);
    for (int i = 4; i <= N; i++) {
      dp[i] = Math.max(dp[i - 2], dp[i - 3] + stairs[i - 1]) + stairs[i];
    }

    System.out.println(dp[N]);
  }
}