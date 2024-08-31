import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int M = Integer.parseInt(br.readLine());
    HashSet<Integer> set = new HashSet<>();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < M; i++) {
      String[] split = br.readLine().split(" ");

      if (split[0].equals("add")) {
        set.add(Integer.parseInt(split[1]));
      } else if (split[0].equals("remove")) {
        set.remove(Integer.parseInt(split[1]));
      } else if (split[0].equals("check")) {
        if (set.contains(Integer.parseInt(split[1]))) {
          sb.append(1).append("\n");
        } else {
          sb.append(0).append("\n");
        }
      } else if (split[0].equals("toggle")) {
        if (set.contains(Integer.parseInt(split[1]))) {
          set.remove(Integer.parseInt(split[1]));
        } else {
          set.add(Integer.parseInt(split[1]));
        }
      } else if (split[0].equals("all")) {
        set.clear();
        for (int j = 1; j <= 20; j++) {
          set.add(j);
        }
      } else if (split[0].equals("empty")) {
        set.clear();
      }
    }
    System.out.println(sb);
  }
}