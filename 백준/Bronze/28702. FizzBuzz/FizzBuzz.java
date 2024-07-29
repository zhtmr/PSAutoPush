import java.io.*;
import java.util.StringTokenizer;

public class Main {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    String[] arr = new String[3];
    for (int i = 0; i < 3; i++) {
      arr[i] = scan.next();
    }

    int[] intArr = new int[3];

    for (int i = 0; i < 3; i++) {
      String string = arr[i];
      if (!string.equals("FizzBuzz") && !string.equals("Fizz") && !string.equals("Buzz")) {
        if (i == 2) {
          intArr[0] = (Integer.parseInt(string) - 2);
          intArr[1] = (Integer.parseInt(string) - 1);
          intArr[2] = (Integer.parseInt(string));
          break;
        } else if (i == 1) {
          intArr[0] = (Integer.parseInt(string) - 1);
          intArr[1] = (Integer.parseInt(string));
          intArr[2] = (Integer.parseInt(string) + 1);
          break;
        } else {
          intArr[0] = (Integer.parseInt(string));
          intArr[1] = (Integer.parseInt(string) + 1);
          intArr[2] = (Integer.parseInt(string) + 2);
          break;
        }
      }
    }
    System.out.println(fizzbuzz(intArr[2] + 1));


  }

  static String fizzbuzz(int a) {

    if (a % 3 == 0 && a % 5 == 0) {
      return "FizzBuzz";
    } else if (a % 3 == 0) {
      return "Fizz";
    } else if (a % 5 == 0) {
      return "Buzz";
    }
    return String.valueOf(a);
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