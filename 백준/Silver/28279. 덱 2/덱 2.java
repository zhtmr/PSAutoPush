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
    Deque deque = new Deque();
    for (int i = 0; i < N; i++) {
      String[] command = scan.nextLine().split(" ");
      deque.execute(command);
    }
    System.out.println(sb);
  }

  static class Deque {
    private final ArrayDeque<Integer> deque = new ArrayDeque<>();

    public void execute(String[] command) {
      switch (Integer.parseInt(command[0])) {
        case 1:
          addFirst(Integer.parseInt(command[1]));
          break;
        case 2:
          addLast(Integer.parseInt(command[1]));
          break;
        case 3:
          sb.append(removeFirst()).append("\n");
          break;
        case 4:
          sb.append(removeLast()).append("\n");
          break;
        case 5:
          sb.append(size()).append("\n");
          break;
        case 6:
          sb.append(isEmpty()).append("\n");
          break;
        case 7:
          sb.append(peekFirst()).append("\n");
          break;
        case 8:
          sb.append(peekLast()).append("\n");
          break;

      }
    }

    void addFirst(int x) {
      deque.addFirst(x);
    }

    void addLast(int x) {
      deque.addLast(x);
    }

    int removeFirst() {
      if (deque.isEmpty()) {
        return -1;
      }
      return deque.removeFirst();
    }

    int removeLast() {
      if (deque.isEmpty()) {
        return -1;
      }
      return deque.removeLast();
    }

    int size() {
      return deque.size();
    }

    int isEmpty() {
      return deque.isEmpty() ? 1 : 0;
    }

    int peekFirst() {
      if (deque.isEmpty()) {
        return -1;
      }
      return deque.peekFirst();
    }

    int peekLast() {
      if (deque.isEmpty()) {
        return -1;
      }
      return deque.peekLast();
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