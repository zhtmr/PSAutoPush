import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder stringBuilder = new StringBuilder();

    while (true) {
      String input = br.readLine();
      if (input == null || input.isEmpty()) {
        break;
      }
      st = new StringTokenizer(input);
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      stringBuilder.append(a + b).append("\n");
    }
    bw.write(String.valueOf(stringBuilder));
    bw.close();
    br.close();

  }

}