import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int h = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int t = Integer.parseInt(br.readLine());


    String time = getTime(h, m, t);

    System.out.println(time);

  }

  static String getTime(int h, int m, int t) {
    if (m + t < 60) {
      m += t;
    } else {
      int quotient = t / 60; // 시간
      int remainder = t % 60; // 분

      if (m + remainder < 60) {
        m += remainder;
        h += quotient;
      } else {
        h += (m + t) / 60;
        m = (m + t) % 60;
      }
    }
    if (h >= 24) {
      h -= 24;
    }
    return String.format("%d %d", h, m);
  }

}