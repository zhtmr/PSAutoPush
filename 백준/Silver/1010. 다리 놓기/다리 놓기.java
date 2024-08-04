import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    int T = scan.nextInt();
    for (int i = 0; i < T; i++) {
      int n = scan.nextInt();
      int m = scan.nextInt();
      sb.append(factorial(m).divide(factorial(m - n).multiply(factorial(n)))).append("\n");
    }
    System.out.println(sb);
  }

  static BigInteger factorial(int x) {
    BigInteger sum = BigInteger.ONE;
    for (int i = 2; i <= x; i++) {
      sum = sum.multiply(BigInteger.valueOf(i));
    }
    return sum;
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