import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    input();
  }

  static void input() throws IOException {
    int N = scan.nextInt();
    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = scan.nextInt();
    }

    Arrays.sort(arr);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for (int i = 0; i < N; i++) {
      try {
        bw.write(arr[i] + "\n");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    bw.close();

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