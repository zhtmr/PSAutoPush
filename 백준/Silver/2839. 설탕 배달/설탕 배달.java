import java.io.*;
import java.util.StringTokenizer;

public class Main {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    int N = scan.nextInt();
    int[] dp = new int[5001];

    for (int i = 0; i <= 5000; i++) {
      dp[i] = -1;
    }

    dp[3] = 1;
    dp[5] = 1;

    for (int i = 6; i <= N; i++) {
      if (dp[i - 3] != -1) {
        dp[i] = dp[i - 3] + 1;
      }
      if (dp[i - 5] != -1) {
        dp[i] = dp[i] == -1 ? dp[i - 5] + 1 : Math.min(dp[i], dp[i - 5] + 1);
      }
    }

    System.out.println(dp[N]);
  }

  static class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
      br = new BufferedReader(new InputStreamReader(System.in));
    }

    public FastReader(String s) throws FileNotFoundException {
      br = new BufferedReader(new FileReader(new File(s)));
    }

    String next() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(next());
    }

    long nextLong() {
      return Long.parseLong(next());
    }

    double nextDouble() {
      return Double.parseDouble(next());
    }

    String nextLine() {
      String str = "";
      try {
        str = br.readLine();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return str;
    }
  }
}