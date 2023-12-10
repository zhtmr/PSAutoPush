import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

      static FastReader scan = new FastReader();
      //정답은 sb에 append 를 사용하여 출력
      //만약 개행까지 출력하고 싶으면 append('\n')을 추가
      static StringBuilder sb = new StringBuilder();

      public static void main(String[] args) throws IOException {
          input();
      }
      static void input() throws IOException {
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

          int n = scan.nextInt();
          int m = scan.nextInt();
          int[] arr = new int[n];

          for (int index = 0; index < m; index++) {
              int i = scan.nextInt();
              int j = scan.nextInt();
              int k = scan.nextInt();
              for (int l = i-1; l < j; l++) {
                  arr[l] = k;
              }
          }

          sb.append(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
          bw.write(String.valueOf(sb));
          bw.close();

      }
      static class FastReader {
          BufferedReader br;
          StringTokenizer st;
          public FastReader() {
              br = new BufferedReader(new InputStreamReader(System.in));
          }
          public FastReader(String s) throws FileNotFoundException {
              br = new BufferedReader(new FileReader(new File(s)));
          }
          String next() {
              while (st == null || !st.hasMoreElements()) {
                  try {
                      st = new StringTokenizer(br.readLine());
                  } catch (IOException e) {
                      e.printStackTrace();
                  }
              }
              return st.nextToken();
          }
          int nextInt() {
              return Integer.parseInt(next());
          }
          long nextLong() {
              return Long.parseLong(next());
          }
          double nextDouble() {
              return Double.parseDouble(next());
          }
          String nextLine() {
              String str = "";
              try {
                  str = br.readLine();
              } catch (IOException e) {
                  e.printStackTrace();
              }
              return str;
          }
      }


}