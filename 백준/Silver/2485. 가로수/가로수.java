import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    int N = scan.nextInt();
    int[] list = new int[N];
    for (int i = 0; i < N; i++) {
      list[i] = scan.nextInt();
    }


    ArrayList<Integer> subtracts = new ArrayList<>();
    for (int i = 1; i < list.length; i++) {
      int x = list[i - 1];
      int y = list[i];
      subtracts.add(Math.abs(x - y));
    }

    int gap = subtracts.get(0);
    for (int i = 1; i < subtracts.size(); i++) {
      gap = gcd(gap, subtracts.get(i));
    }

    int count = 0;
    for (int i = 0; i < subtracts.size(); i++) {
      count += (subtracts.get(i) / gap) - 1;
    }

    System.out.println(count);

  }

  private static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
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