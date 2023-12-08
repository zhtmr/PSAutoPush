import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {


      static FastReader scan = new FastReader();
      static StringBuilder sb = new StringBuilder();

      public static void main(String[] args) throws IOException {
          input();
      }
      static void input() throws IOException {

          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

          int N = scan.nextInt();
          int x = scan.nextInt();
          int[] arr = new int[N];

          for (int i = 0; i < N; i++) {
              arr[i] = scan.nextInt();
          }
          for (int i = 0; i < arr.length; i++) {
              if (arr[i] < x) {
                  sb.append(arr[i]).append(" ");
              }
          }
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