import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    sameCount(a, b, c);

  }

  static void sameCount(int a, int b, int c) {

    List<Integer> list = Arrays.asList(a, b, c);

    int aCount = (int) list.stream().filter(e -> e.equals(a)).count();
    int bCount = (int) list.stream().filter(e -> e.equals(b)).count();
    int cCount = (int) list.stream().filter(e -> e.equals(c)).count();
    int maxCount = Math.max(Math.max(aCount, bCount), cCount);

    List<Integer> countList = Arrays.asList(aCount, bCount, cCount);
    if (maxCount == 3) {
      System.out.println(10000 + a * 1000);
    } else if (maxCount == 2) {
      int target = 0;
      for (int i = 0; i < countList.size(); i++) {
        Integer e = countList.get(i);
        if (e == maxCount) {
          target = list.get(i);
        }
      }
      System.out.println(1000 + target * 100);
    } else {
      int max = Math.max(Math.max(a, b), c);
      System.out.println(max * 100);
    }

  }

}