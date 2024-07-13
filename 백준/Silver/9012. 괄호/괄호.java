import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    int T = scan.nextInt();
    for (int i = 0; i < T; i++) {
      String[] split = scan.next().split("");
      isVPS(split);
    }
    System.out.println(sb);
  }

  private static void isVPS(String[] split) {
    Deque<String> stack = new ArrayDeque<>();
    for (String s : split) {
      if (s.equals("(")) {
        stack.push(s);
      } else if (s.equals(")")) {
        if (stack.isEmpty()) {
          sb.append("NO").append("\n");
          return;
        }
        stack.pop();
      }
    }
    if (stack.isEmpty()) {
      sb.append("YES").append("\n");
    } else {
      sb.append("NO").append("\n");
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