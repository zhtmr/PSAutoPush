import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();


  public static void main(String[] args) {
    input();
  }

  static void input() {
    while (true) {
      String[] split = scan.nextLine().split("");
      if (split[0].equals(".")) {
        break;
      }
      sb.append(check(split) ? "yes" : "no").append("\n");
    }
    System.out.println(sb);
  }

  private static boolean check(String[] split) {
    ArrayDeque<String> stack = new ArrayDeque<>();
    for (String s : split) {
      if (s.equals("(") || s.equals("[")) {
        stack.push(s);
      } else if (s.equals(")")) {
        if (stack.isEmpty() || !stack.pop().equals("(")) {
          return false;
        }
      } else if (s.equals("]")) {
        if (stack.isEmpty() || !stack.pop().equals("[")) {
          return false;
        }
      }
    }
    return stack.isEmpty();
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