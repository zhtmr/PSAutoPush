import java.io.*;
import java.util.*;

public class Main {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    int n = scan.nextInt();
    int trimmed = (int) Math.round(n * 0.15);


//    System.out.println("trimmed = " + trimmed);

    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list.add(scan.nextInt());
    }

    Collections.sort(list);

//    System.out.println("prev-list = " + list);

    List<Integer> trimmedList = list.subList(trimmed, n - trimmed);

    //    System.out.println("after-list = " + list);

    int num = trimmedList.size();
    int sum = 0;

    for (Integer integer : trimmedList) {
      sum += integer;
    }

//    System.out.println("sum = " + sum);
//    System.out.println("num = " + num);
    System.out.println(Math.round((double) sum / num));
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