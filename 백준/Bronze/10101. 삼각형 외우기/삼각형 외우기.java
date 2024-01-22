import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    int a = scan.nextInt();
    int b = scan.nextInt();
    int c = scan.nextInt();

    List<String> collect = Arrays.stream(Triangle.values()).map(e -> e.calculate(a, b, c)).collect(
        Collectors.toList());
    System.out.println(collect.stream().filter(Objects::nonNull).collect(Collectors.joining()));
  }

  enum Triangle {
    EQUILATERAL("Equilateral", (a, b, c) -> a == 60 && b == 60 && c == 60),
    ISOSCELES("Isosceles", (a,b,c) -> a + b + c == 180 && ((a == b && a != c) || (b == c && b != a) || (a == c && a != b))),
    SCALENE("Scalene", (a,b,c) -> a + b + c == 180 && a != b && b != c && a != c),
    ERROR("Error", (a,b,c) -> a + b + c != 180);

    private final String name;
    private final TriangleFunc expression;

    Triangle(String name, TriangleFunc expression) {
      this.name = name;
      this.expression = expression;
    }

    public String getName() {
      return name;
    }

    public String calculate(int a, int b, int c) {
      return expression.test(a, b, c) ? this.getName() : null;
    }
  }

  interface TriangleFunc {
    boolean test(int a, int b, int c);
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