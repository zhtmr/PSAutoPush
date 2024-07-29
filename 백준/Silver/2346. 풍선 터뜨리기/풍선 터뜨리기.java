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
    int N = scan.nextInt();
    ArrayDeque<int[]> deque = new ArrayDeque<>();
    for (int i = 1; i <= N; i++) {
      deque.offer(new int[] {i, scan.nextInt()});
    }


    while (!deque.isEmpty()) {
      int[] current = deque.pollFirst();
      int idx = current[0];
      int move = current[1];

      sb.append(idx).append(" ");

      if (deque.isEmpty()) {
        break;
      }

      if (move > 0) {
        for (int i = 0; i < move - 1; i++) {
          deque.offerLast(deque.pollFirst());
        }
      } else {
        for (int i = 0; i < Math.abs(move); i++) {
          deque.offerFirst(deque.pollLast());
        }
      }
    }

    System.out.println(sb);

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