import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
    System.out.println(sb);
  }

  static void input() {
    int T = scan.nextInt();

    for (int i = 0; i < T; i++) {
      int N = scan.nextInt();
      int M = scan.nextInt();
      ArrayDeque<Node> queue = new ArrayDeque<>();
      for (int j = 0; j < N; j++) {
        queue.offer(new Node(scan.nextInt(), j));
      }

      int count = 0;
      while (!queue.isEmpty()) {
        Node current = queue.poll();
        if (check(queue, current)) {
          queue.offerLast(current);
        } else {
          count++;
          if (current.idx == M) {
            break;
          }
        }
      }

      sb.append(count).append("\n");
    }

  }

  private static boolean check(ArrayDeque<Node> q, Node current) {
    for (Node node : q) {
      if (node.value > current.value) {
        return true;
      }
    }
    return false;
  }

  static class Node {
    int value;
    int idx;

    Node(int value, int idx) {
      this.value = value;
      this.idx = idx;
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