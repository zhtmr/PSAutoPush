import java.io.*;
import java.util.*;

public class Main {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {

    int T = scan.nextInt();
    for (int i = 0; i < T; i++) {
      TreeMap<Integer, Integer> map = new TreeMap<>();
      int k = scan.nextInt();

      for (int j = 0; j < k; j++) {
        String command = scan.next();
        int num = scan.nextInt();
        if (command.equals("I")) {
          map.put(num, map.getOrDefault(num, 0) + 1);
        } else if (command.equals("D")) {
          if (map.isEmpty()) {
            continue;
          }
          if (num == 1) {
            Integer max = map.lastKey();
            if (map.get(max) == 1) {
              map.remove(max);
            } else {
              map.put(max, map.get(max) - 1);
            }
          } else {
            Integer min = map.firstKey();
            if (map.get(min) == 1) {
              map.remove(min);
            } else {
              map.put(min, map.get(min) - 1);
            }
          }
        }
      }

      if (map.isEmpty()) {
        sb.append("EMPTY").append("\n");
      } else {
        sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
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