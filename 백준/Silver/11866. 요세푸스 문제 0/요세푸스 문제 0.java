import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    int N = scan.nextInt();
    int K = scan.nextInt();
    for (int i = 1; i <= N; i++) {
      queue.offer(i);
    }
    ArrayList<Integer> list = new ArrayList<>();

    while (!queue.isEmpty()) {
      for (int i = 0; i < K - 1; i++) {
        queue.addLast(queue.pollFirst());
      }
      list.add(queue.pollFirst());
    }

    sb.append("<");
    for (int i = 0; i < list.size(); i++) {
      sb.append(list.get(i));
      if (i == list.size() - 1) {
        sb.append(">");
      } else {
        sb.append(", ");
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