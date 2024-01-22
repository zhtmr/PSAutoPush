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
    int n = scan.nextInt();
    int[] x_arr = new int[n];
    int[] y_arr = new int[n];
    for (int i = 0; i < n; i++) {
      x_arr[i] = scan.nextInt();
      y_arr[i] = scan.nextInt();
    }
    int answer = calculate(x_arr, y_arr);
    System.out.println(answer);
  }

  static int calculate(int[] x_arr, int[] y_arr) {
    return
        Math.abs(Arrays.stream(x_arr).max().getAsInt() - Arrays.stream(x_arr).min().getAsInt())
    * Math.abs(Arrays.stream(y_arr).max().getAsInt() - Arrays.stream(y_arr).min().getAsInt());

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