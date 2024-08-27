import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    PriorityQueue<Integer> absMinHeap = new PriorityQueue<>((o1, o2) -> {
      int absCompare = Integer.compare(Math.abs(o1), Math.abs(o2));
      if (absCompare == 0) {
        return o1.compareTo(o2);
      } else {
        return absCompare;
      }
    });

    int N = Integer.parseInt(st.nextToken());
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());
      if (num != 0) {
        absMinHeap.add(num);
      } else {
        if (absMinHeap.isEmpty()) {
          sb.append(0).append("\n");
          continue;
        }
        sb.append(absMinHeap.poll()).append("\n");
      }
    }
    System.out.println(sb);

  }
}