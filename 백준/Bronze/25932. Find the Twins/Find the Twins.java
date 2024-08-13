import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      String numbers = br.readLine();
      sb.append(numbers).append("\n");
      if (numbers.contains("18") && numbers.contains("17")) {
        sb.append("both").append("\n").append("\n");
      } else if (numbers.contains("17")) {
        sb.append("zack").append("\n").append("\n");
      } else if (numbers.contains("18")) {
        sb.append("mack").append("\n").append("\n");
      } else {
        sb.append("none").append("\n").append("\n");
      }
    }
    System.out.println(sb);
  }
}