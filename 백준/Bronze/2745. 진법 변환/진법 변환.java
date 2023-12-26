import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    String[] arr = new String[36];
    for (int i = 0; i < 36; i++) {
      arr[i] = String.valueOf(i);
      if (i > 9) {
        arr[i] = String.valueOf((char) (i - 10 + 'A'));
      }
    }

    String s = scan.next();
    int n = scan.nextInt();
    int result = 0;

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      for (int j = 0; j < arr.length; j++) {
        if (c == arr[j].charAt(0)) {
          result += (int) (j * Math.pow(n, s.length() - i - 1));
          break;
        }
      }
    }
    System.out.println(result);

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