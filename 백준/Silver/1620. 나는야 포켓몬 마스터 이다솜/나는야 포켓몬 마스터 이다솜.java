import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    int N = scan.nextInt();
    int M = scan.nextInt();

    HashMap<String, Integer> stringMap = new HashMap<>();
    HashMap<Integer, String> integerMap = new HashMap<>();
    for (int i = 1; i <= N; i++) {
      String key = scan.next();
      stringMap.put(key, i);
      integerMap.put(i, key);
    }

    for (int i = 0; i < M; i++) {
      String s = scan.next();
      if (isNumber(s)) {
        System.out.println(integerMap.get(Integer.parseInt(s)));
      } else {
        System.out.println(stringMap.get(s));
      }
    }
  }

  private static boolean isNumber(String s) {
    try {
      Integer.parseInt(s);
      return true;
    } catch (NumberFormatException e) {
      return false;
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