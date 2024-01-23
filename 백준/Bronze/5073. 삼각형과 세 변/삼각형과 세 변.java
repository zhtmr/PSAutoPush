import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {

    while (true) {
      int a = scan.nextInt();
      int b = scan.nextInt();
      int c = scan.nextInt();

      if (a == 0 && b == 0 && c == 0) {
        break;
      }

      String name =
          Arrays.stream(Triangle.values()).map(t -> t.calculate(a, b, c)).findAny().get().getName();

      System.out.println(name);
    }

  }

  enum Triangle {
    EQUILATERAL("Equilateral", new Validation()), ISOSCELES("Isosceles", new Validation()), SCALENE(
        "Scalene", new Validation()), INVALID("Invalid", new Validation());

    private final String name;
    private final TriangleFunc expression;

    Triangle(String name, TriangleFunc expression) {
      this.name = name;
      this.expression = expression;
    }

    public String getName() {
      return name;
    }

    public Triangle calculate(int a, int b, int c) {
      return expression.test(a, b, c);
    }
  }


  interface TriangleFunc {
    Triangle test(int a, int b, int c);
  }


  static class Validation implements TriangleFunc {

    @Override
    public Triangle test(int a, int b, int c) {
      Integer[] arr = new Integer[] {a, b, c};

      int max = Math.max(Math.max(arr[0], arr[1]), arr[2]);

      List<Integer> duplicateList =
          Arrays.stream(arr).collect(Collectors.groupingBy(n -> n, Collectors.counting()))
              .entrySet().stream().filter(e -> e.getValue() > 1).map(Map.Entry::getKey)
              .collect(Collectors.toList());

      int size = duplicateList.size();
      int duplicateNum = size != 0 ? duplicateList.get(0) : 0;

      int sum = Arrays.stream(arr).mapToInt(integer -> integer).filter(value -> value < max).sum();

      if (duplicateNum == max) {
        sum += duplicateNum;
      }

      if (a == b && b == c) {
        return Triangle.EQUILATERAL;
      } else if (!(max >= sum) && (a == b || b == c || a == c)) {
        return Triangle.ISOSCELES;
      } else if (max >= sum) {
        return Triangle.INVALID;
      } else {
        return Triangle.SCALENE;
      }
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