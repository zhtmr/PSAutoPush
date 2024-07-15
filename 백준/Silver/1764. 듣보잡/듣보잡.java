import java.io.*;
import java.util.*;

public class Main {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    int N = scan.nextInt();
    int M = scan.nextInt();

    HashSet<String> noEar = new HashSet<>();
    for (int i = 0; i < N; i++) {
      noEar.add(scan.next());
    }

    ArrayList<String> list = new ArrayList<>();

    for (int i = 0; i < M; i++) {
      String s = scan.next();
      if (noEar.contains(s)) {
        list.add(s);
      }
    }

    Collections.sort(list);
    System.out.println(list.size());
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
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