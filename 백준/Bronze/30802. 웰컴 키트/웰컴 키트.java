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
    int[] arr = new int[6];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scan.nextInt();
    }
    int T = scan.nextInt();
    int P = scan.nextInt();

    int[] cnt = new int[6];
    for (int i = 0; i < 6; i++) {
      if (arr[i] <= T) {
        if (arr[i] == 0) {
          cnt[i] = 0;
          continue;
        }
        cnt[i] = 1;
      } else {
        cnt[i] = (int) Math.ceil((double) arr[i] / T);
      }
    }

    int sum = 0;
    for (int num : cnt) {
      sum += num;
    }

    System.out.println(sum);
    System.out.printf("%d %d", N / P, N % P);

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