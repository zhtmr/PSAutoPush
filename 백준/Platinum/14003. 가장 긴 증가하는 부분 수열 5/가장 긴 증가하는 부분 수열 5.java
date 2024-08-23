import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] nums = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    int[] lis = new int[N];
    int[] trace = new int[N];

    int len = 0;
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      int pos = Arrays.binarySearch(lis, 0, len, num);
      if (pos < 0) {
        pos = -(pos + 1);
      }
      lis[pos] = num;
      trace[i] = pos;

      if (pos == len) {
        len++;
      }
    }

    ArrayList<Integer> result = new ArrayList<>();
    for (int i = N - 1; i >= 0; i--) {
      if (trace[i] == len - 1) {
        result.add(nums[i]);
        len--;
      }
    }

//    System.out.println("nums = " + Arrays.toString(nums));
//    System.out.println("lis = " + Arrays.toString(lis));
//    System.out.println("trace = " + Arrays.toString(trace));
    StringBuilder sb = new StringBuilder();
    sb.append(result.size()).append("\n");
    for (int i = result.size() - 1; i >= 0; i--) {
      sb.append(result.get(i)).append(" ");
    }
    System.out.println(sb);
  }
}