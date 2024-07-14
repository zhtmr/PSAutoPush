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
    int N = scan.nextInt();
    Queue queue = new Queue();
    for (int i = 0; i < N; i++) {
      String[] command = scan.nextLine().split(" ");
      queue.execute(command);
    }
    System.out.println(sb);
  }

  static class Queue {
    private final Deque<Integer> queue = new ArrayDeque<>();

    public void execute(String[] command) {
      switch (command[0]) {
        case "push":
          push(Integer.parseInt(command[1]));
          break;
        case "pop":
          sb.append(pop()).append("\n");
          break;
        case "front":
          sb.append(front()).append("\n");
          break;
        case "back":
          sb.append(back()).append("\n");
          break;
        case "size":
          sb.append(size()).append("\n");
          break;
        case "empty":
          sb.append(empty()).append("\n");
          break;
      }
    }

    void push(int x) {
      queue.offer(x);
    }

    int pop() {
      if (queue.isEmpty()) {
        return -1;
      }
      return queue.pop();
    }

    int size() {
      return queue.size();
    }

    int empty() {
      if (queue.isEmpty()) {
        return 1;
      }
      return 0;
    }

    int front() {
      if (size() == 0) {
        return -1;
      }
      return queue.getFirst();
    }

    int back() {
      if (size() == 0) {
        return -1;
      }
      return queue.getLast();
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