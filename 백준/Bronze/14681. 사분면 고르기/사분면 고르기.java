import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int x = readLine(br);
    int y = readLine(br);

    // 1사, 2사, 3사, 4사
//    int[] x = {1, -1, -1, 1};
//    int[] y = {1, 1, -1, -1};
    if (x > 0 && y > 0) {
      System.out.println(1);
    } else if (x < 0 && y > 0) {
      System.out.println(2);
    } else if (x < 0 && y < 0) {
      System.out.println(3);
    } else if (x > 0 && y < 0) {
      System.out.println(4);
    }


  }

  static int readLine(BufferedReader br) throws IOException {
    return Integer.parseInt(br.readLine());
  }

}