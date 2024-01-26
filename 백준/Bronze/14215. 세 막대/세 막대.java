import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    int sum;
    int a = scan.nextInt();
    int b = scan.nextInt();
    int c = scan.nextInt();
    int max = Math.max(Math.max(a, b), c);

    List<Integer> list = new ArrayList<>();
    for (int i : new int[] {a, b, c}) {
      list.add(i);
    }

    if (a == b && b == c) {
      System.out.println(a + b + c);
      return;
    }

    List<Integer> dList =
        list.stream().collect(Collectors.groupingBy(integer -> integer, Collectors.counting()))
            .entrySet().stream().filter(e -> e.getValue() > 1).map(Map.Entry::getKey)
            .collect(Collectors.toList());

    int dNum = !dList.isEmpty() ? dList.get(0) : 0;

    list.stream().filter(integer -> integer.equals(max)).findAny().filter(list::remove);

    sum = list.stream().mapToInt(value -> value).filter(value -> value < max).sum();
    if (dNum == max) {
      sum += dNum;
    }

    if (max >= sum) {
      System.out.println(sum + sum - 1);
    } else {
      System.out.println(a + b + c);
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