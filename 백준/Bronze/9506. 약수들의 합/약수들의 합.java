import java.io.*;
import java.util.StringTokenizer;

public class Main {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    int n;
    int sum = 0;
    StringBuilder p = new StringBuilder();
    while ((n = scan.nextInt()) != -1) {
      for (int i = 1; i < n; i++) {
        if (n % i == 0) {
          sum += i;
          p.append(i).append(" + ");
        }
      }
      if (sum == n) {
        sb.append(n).append(" = ").append(p).append("\n").delete(sb.length() - 3, sb.length() - 1);
      } else {
        sb.append(n).append(" is NOT perfect.").append("\n");
      }
      sum = 0;
      p = new StringBuilder();
    }
    System.out.println(sb);
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