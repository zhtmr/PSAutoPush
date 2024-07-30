import java.io.*;
import java.util.StringTokenizer;

public class Main {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    char[] alphabet = new char[27];
    for (int i = 1; i <= 26; i++) {
      alphabet[i] = (char) ('a' + i - 1);
    }

    int L = scan.nextInt();
    String s = scan.next();

    System.out.println(hashFun(alphabet, L, s));

  }

  static int hashFun(char[] alphabet, int len, String s) {
    int r = 31;
    int M = 1234567891;
    double sum = 0;
    for (int i = 0; i < s.length(); i++) {
      for (int j = 0; j < alphabet.length; j++) {
        if (s.charAt(i) == alphabet[j]) {
          sum += j * Math.pow(r, i);
        }
      }
    }

    return (int) (sum % M);
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