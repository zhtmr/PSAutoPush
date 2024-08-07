import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<Integer> list = new ArrayList<>();
    int index = 1;
    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int n = Integer.parseInt(st.nextToken());
      if (n == 0) {
        break;
      }

      for (int i = 0; i < n; i++) {
        list.add(Integer.parseInt(st.nextToken()));
      }

      Collections.sort(list);
      System.out.printf("Case %d: Sorting... done!\n", index++);
    }
  }
}