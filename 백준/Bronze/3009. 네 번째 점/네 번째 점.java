import java.io.*;
import java.util.*;

public class Main {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    int[] arr_x = new int[3];
    int[] arr_y = new int[3];
    for (int i = 0; i < 3; i++) {
      arr_x[i] = scan.nextInt();
      arr_y[i] = scan.nextInt();
    }

    int x = find_unique_num(arr_x);
    int y = find_unique_num(arr_y);

    System.out.printf("%d %d", x, y);
  }

  static int find_unique_num(int[] arr) {
    if (arr[1] == arr[2]) {
      return arr[0];
    } else if (arr[0] == arr[2]) {
      return arr[1];
    } else if (arr[0] == arr[1]) {
      return arr[2];
    }
    return 0;
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