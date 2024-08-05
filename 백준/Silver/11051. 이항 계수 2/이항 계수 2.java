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
    int K = scan.nextInt();

    int[][] dp = new int[N + 1][K + 1];

    for (int i = 0; i <= N; i++) {
      dp[i][0] = 1;
    }

    for (int i = 0; i <= K; i++) {
      dp[i][i] = 1;
    }

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= K; j++) {
        dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - 1]) % 10007;
      }
    }

    System.out.println(dp[N][K]);
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