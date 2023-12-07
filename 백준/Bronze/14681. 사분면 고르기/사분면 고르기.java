import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int x = readLine(br);
    int y = readLine(br);
    System.out.println(getQuadrant(x, y));


  }

  static int readLine(BufferedReader br) throws IOException {
    return Integer.parseInt(br.readLine());
  }

  static int getQuadrant(int x, int y){
    if (x * y > 0) {
      if (x > 0) {
        return 1;
      } else {
        return 3;
      }
    } else {
      if (x > 0) {
        return 4;
      } else {
        return 2;
      }
    }
  }

}