import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());
      if (num > 0) {
        minHeap.add(num);
      } else {
        if (minHeap.isEmpty()) {
          list.add(0);
          continue;
        }
        list.add(minHeap.poll());
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int num : list) {
      sb.append(num).append("\n");
    }

    System.out.println(sb);
  }
}