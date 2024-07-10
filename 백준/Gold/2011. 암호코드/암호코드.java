import java.io.*;
import java.util.StringTokenizer;

public class Main {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    String str = scan.next();
    if (str.charAt(0) == '0') {
      System.out.println(0);
      return;
    }
    int n = str.length();
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      int oneNum = Integer.parseInt(str.substring(i - 1, i));
      int twoNum = Integer.parseInt(str.substring(i - 2, i));
      if (oneNum >= 1 && oneNum <= 9) {
        dp[i] += dp[i - 1] % 1000000;
      }
      if (twoNum >= 10 && twoNum <= 26) {
        dp[i] += dp[i - 2] % 1000000;
      }
    }
    System.out.println(dp[n] % 1000000);

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