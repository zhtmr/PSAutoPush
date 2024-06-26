import java.io.*;
import java.util.StringTokenizer;

public class Main {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    int N = scan.nextInt();
    int[][] arr = new int[N][2];
    for (int i = 0; i < N; i++) {
      arr[i][0] = scan.nextInt();
      arr[i][1] = scan.nextInt();
    }
    for (int i = 0; i < N; i++) {
      int rank = 1;
      for (int j = 0; j < N; j++) {
        if (i == j) continue;
        if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
          rank++;
        }
      }
      sb.append(rank).append(" ");
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