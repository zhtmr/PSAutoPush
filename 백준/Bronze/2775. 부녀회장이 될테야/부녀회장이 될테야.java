import java.io.*;
import java.util.StringTokenizer;

public class Main {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    int[][] dp = new int[15][15];
    for (int j = 1; j < 15; j++) {
      dp[0][j] = j;
    }

    for (int i = 1; i < 15; i++) {
      for (int j = 1; j < 15; j++) {
        if (j == 1) {
          dp[i][j] = dp[j - 1][j];
        } else {
          dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
        }
      }
    }

    int T = scan.nextInt();
    for (int i = 0; i < T; i++) {
      sb.append(dp[scan.nextInt()][scan.nextInt()]).append("\n");
    }

    System.out.println(sb);

//    System.out.println(Arrays.deepToString(dp));
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