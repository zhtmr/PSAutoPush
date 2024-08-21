import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    int len = 0;
    for (int num : nums) {
      int pos = Arrays.binarySearch(lis, 0, len, num);
      if (pos < 0) {
        pos = -(pos + 1);
      }
      lis[pos] = num;
      if (pos == len) {
        len++;
      }
    }

    System.out.println(len);
  }
}