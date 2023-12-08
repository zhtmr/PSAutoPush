import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(st.nextToken());
    ArrayList<Integer> arr = new ArrayList<>();
    int count = 0;

    StringTokenizer numbers = new StringTokenizer(br.readLine());
    while (numbers.hasMoreElements()){
      arr.add(Integer.parseInt(numbers.nextToken()));
    }

    int v = Integer.parseInt(br.readLine());

    for (int j : arr) {
      if (j == v) {
        count++;
      }
    }

    bw.write(String.valueOf(sb.append(count)));
    bw.flush();
    bw.close();
  }

}