import java.io.*;
import java.util.StringTokenizer;

public class Main {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    int K = scan.nextInt();
    int N = scan.nextInt();
    int[] arr = new int[K];

    int max = 0;
    for (int i = 0; i < K; i++) {
      arr[i] = scan.nextInt();
      if (arr[i] > max) {
        max = arr[i];
      }
    }


    long start = 1;
    long end = max;

    long result = 0;
    while (start <= end) {
      long mid = (start + end) / 2;

      long count = 0;
      for (int i = 0; i < K; i++) {
        count += arr[i] / mid;
      }
      if (count >= N) {
        result = mid;
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    System.out.println(result);
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