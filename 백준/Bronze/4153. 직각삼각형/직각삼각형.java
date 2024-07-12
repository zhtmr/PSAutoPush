import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    while (true) {
      String s = scan.nextLine();
      if (s.equals("0 0 0")) {
        break;
      }
      String[] split = s.split(" ");
      int[] ints = new int[split.length];
      for (int i = 0; i < split.length; i++) {
        ints[i] = Integer.parseInt(split[i]);
      }
      Arrays.sort(ints);

      if (ints[2] * ints[2] == ints[0] * ints[0] + ints[1] * ints[1]) {
        System.out.println("right");
      } else {
        System.out.println("wrong");
      }
    }
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