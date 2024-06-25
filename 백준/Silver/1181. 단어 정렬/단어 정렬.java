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
    String[] arr = new String[N];
    for (int i = 0; i < N; i++) {
      arr[i] = scan.nextLine();
    }
    sort(arr);
  }

  private static void sort(String[] arr) {
    Arrays.sort(arr, (o1, o2) -> {
      if (o1.length() == o2.length()) {
        return o1.compareTo(o2);
      } else {
        return o1.length() - o2.length();
      }
    });
    for (int i = 0; i < arr.length; i++) {
      if (i > 0 && arr[i].equals(arr[i - 1])) {
        continue;
      }
      System.out.println(arr[i]);
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