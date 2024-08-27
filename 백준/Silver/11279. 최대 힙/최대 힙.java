import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());
      if (num > 0) {
        maxHeap.add(num);
      } else if (num == 0) {
        if (maxHeap.isEmpty()) {
          sb.append(0).append("\n");
          continue;
        }
        sb.append(maxHeap.poll()).append("\n");
      }
    }
    System.out.println(sb);
  }
}