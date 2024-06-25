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

    String[] distinct = Arrays.stream(arr).distinct().toArray(String[]::new);
    for (int i = 0; i < distinct.length; i++) {
      for (int j = i + 1; j < distinct.length; j++) {
        if (distinct[i].length() > distinct[j].length()) {
          String temp = distinct[i];
          distinct[i] = distinct[j];
          distinct[j] = temp;
        } else if (distinct[i].length() == distinct[j].length()) {
          if (distinct[i].compareTo(distinct[j]) > 0) {
            String temp = distinct[i];
            distinct[i] = distinct[j];
            distinct[j] = temp;
          }
        }
      }
    }
    for (String s : distinct) {
      System.out.println(s);
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