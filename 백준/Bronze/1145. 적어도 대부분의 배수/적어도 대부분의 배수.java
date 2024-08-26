import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s = br.readLine();
    String[] split = s.split(" ");
    int minLcm = Integer.MAX_VALUE;

    for (int i = 0; i < 5; i++) {
      for (int j = i + 1; j < 5; j++) {
        for (int k = j + 1; k < 5; k++) {
          int a = Integer.parseInt(split[i]);
          int b = Integer.parseInt(split[j]);
          int c = Integer.parseInt(split[k]);
          minLcm = Math.min(minLcm, lcm(lcm(a, b), c));
        }
      }

    }

    System.out.println(minLcm);
  }

  private static int lcm(int a, int b) {
    return (a * b / gcd(a, b));
  }

  private static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }
}