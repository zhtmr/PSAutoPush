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
    dp[3] = 1;
    dp[4] = -1;
    dp[5] = 1;
    dp[6] = 2;
    dp[7] = -1;
//    dp[8] = 2;
//    dp[9] = 3;
//    dp[10] = 2;
//    dp[11] = 3;
//    dp[12] = 4;
//    dp[13] = 3;
//    dp[14] = 4;
//    dp[15] = 3;
//    dp[16] = 4;
//    dp[17] = 5;
//    dp[18] = 4;
//    dp[19] = 5;
//    dp[20] = 4;



    for (int i = 8; i < dp.length; i++) {
      if (dp[i - 3] == -1) {
        dp[i] = dp[i - 5] + 1;
      } else if (dp[i - 5] == -1) {
        dp[i] = dp[i - 3] + 1;
      } else {
        dp[i] = Math.min(dp[i - 3] + 1, dp[i - 5] + 1);
      }
    }

//    for (int i = 3; i < N; i++) {
//      System.out.println("i = " + i + " " + dp[i]);
//    }

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