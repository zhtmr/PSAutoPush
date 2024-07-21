import java.io.*;
import java.util.StringTokenizer;

public class Main {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    while (true) {
      int n = scan.nextInt();

      if (n == 0) {
        break;
      }
      System.out.println(primeCnt(n));
    }
  }

  static int primeCnt(int n) {
    int cnt = 0;
    boolean[] arr = new boolean[2 * n + 1];
    arr[0] = arr[1] = true;

    for (int i = 2; i * i <= 2 * n; i++) {
      if (!arr[i]) {
        for (int j = i * i; j <= 2 * n; j += i) {
          arr[j] = true;
        }
      }
    }

    for (int i = n + 1; i <= 2 * n; i++) {
      if (!arr[i]) {
        cnt++;
      }
    }
    return cnt;
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