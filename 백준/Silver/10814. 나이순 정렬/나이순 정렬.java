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
    int N = scan.nextInt();
    String[][] arr = new String[N][3];
    for (int i = 0; i < N; i++) {
      arr[i][0] = scan.next();
      arr[i][1] = scan.next();
      arr[i][2] = String.valueOf(i);
    }
    Arrays.sort(arr, (o1, o2) -> {
      if (o1[0].equals(o2[0])) {
        return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]);
      } else {
        return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
      }
    });

    for (int i = 0; i < N; i++) {
      sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
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