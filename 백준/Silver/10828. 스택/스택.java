import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    int N = scan.nextInt();
    Stack stack = new Stack();
    for (int i = 0; i < N; i++) {
      String[] command = scan.nextLine().split(" ");
      stack.execute(command);
    }
    System.out.println(sb);
  }

  static class Stack {
    private final LinkedList<Integer> stack = new LinkedList<>();

    public void execute(String[] command) {
      switch (command[0]) {
        case "push":
          push(Integer.parseInt(command[1]));
          break;
        case "pop":
          sb.append(pop()).append("\n");
          break;
        case "top":
          sb.append(top()).append("\n");
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
      stack.add(x);
    }

    int pop() {
      if (stack.isEmpty()) {
        return -1;
      }
      return stack.removeLast();
    }

    int size() {
      return stack.size();
    }

    int empty() {
      return stack.isEmpty() ? 1 : 0;
    }

    int top() {
      return stack.isEmpty() ? -1 : stack.getLast();
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