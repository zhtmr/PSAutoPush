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
    int n = scan.nextInt();
    int[] nums = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = scan.nextInt();
    }


    ArrayDeque<Integer> stack = new ArrayDeque<>();
    int current = 1;
    boolean possible = true;
    for (int num : nums) {
      while (current <= num) {
        stack.push(current);
        sb.append("+\n");
        current++;
      }

      if (stack.peek() == num) {
        stack.pop();
        sb.append("-\n");
      } else {
        possible = false;
        break;
      }
    }

    if (possible) {
      System.out.println(sb);
    } else {
      System.out.println("NO");
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