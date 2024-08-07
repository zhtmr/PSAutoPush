import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int bread;
  static int patty;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    bread = Integer.parseInt(st.nextToken());
    patty = Integer.parseInt(st.nextToken());


    System.out.println(Math.min(bread / 2, patty));
  }
}