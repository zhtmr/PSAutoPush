import java.io.*;
import java.util.StringTokenizer;

public class Main {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    int n = scan.nextInt();
    int candidate = 1;
    int max;
    if (n < 10) {
      System.out.println(n % 2 == 0 ? n / 2 : 0);
      return;
    }

    while (true) {
      char[] digits = String.valueOf(candidate).toCharArray();

      int sum = 0;
      for (char digit : digits) {
        sum += digit - '0';
      }
      max = candidate + sum;

      if (max == n) {
        System.out.println(candidate);
        break;
      }


      if (n < candidate) {
        System.out.println(0);
        break;
      }
      candidate++;
    }
  }
// 99999        99963          99959

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