import java.io.*;
import java.util.*;

public class Main {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    Queue<Integer> queue = new ArrayDeque<>();
    ArrayDeque<Integer> stack = new ArrayDeque<>();
    int N = scan.nextInt();
    for (int i = 0; i < N; i++) {
      queue.offer(scan.nextInt());
    }

    int num = 1;
    boolean flag = true;

    while (!queue.isEmpty() || !stack.isEmpty()) {
      if (!queue.isEmpty() && queue.peek() == num) {
        queue.poll();
        num++;
      } else if (!stack.isEmpty() && stack.peek() == num) {
        stack.pop();
        num++;
      } else if (!queue.isEmpty()) {
        stack.push(queue.poll());
      } else {
        flag = false;
        break;
      }
    }

    if (flag) {
      System.out.println("Nice");
    } else {
      System.out.println("Sad");
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