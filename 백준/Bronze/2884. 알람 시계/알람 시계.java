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


    String time = getTime(h,m);
    System.out.println(time);

  }

  private static String getTime(int h, int m) {
    if (m - 45 < 0) {
      --h;
      if (h < 0) {
        h = h + 24;
      }
      return String.format("%d %d", h, m + 60 - 45);
    } else {
      return String.format("%d %d",h, m - 45);
    }
  }


}