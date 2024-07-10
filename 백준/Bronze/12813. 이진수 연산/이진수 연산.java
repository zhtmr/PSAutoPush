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
    String A = scan.next();
    String B = scan.next();

    BigInteger a = new BigInteger(A, 2);
    BigInteger b = new BigInteger(B, 2);

    // A & B
    sb.append(String.format("%" + A.length() + "s", a.and(b).toString(2)).replace(" ", "0")).append("\n");
    // A | B
    sb.append(String.format("%" + A.length() + "s", a.or(b).toString(2)).replace(" ", "0")).append("\n");
    // A ^ B
    sb.append(String.format("%" + A.length() + "s", a.xor(b).toString(2)).replace(" ", "0")).append("\n");
    // ~ A
    sb.append(String.format("%" + A.length() + "s", a.not().and(BigInteger.ONE.shiftLeft(A.length()).subtract(BigInteger.ONE)).toString(2)).replace(" ", "0")).append("\n");
    // ~ B
    sb.append(String.format("%" + A.length() + "s", b.not().and(BigInteger.ONE.shiftLeft(B.length()).subtract(BigInteger.ONE)).toString(2)).replace(" ", "0")).append("\n");

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