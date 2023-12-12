import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

      static FastReader scan = new FastReader();
      //정답은 sb에 append 를 사용하여 출력
      //만약 개행까지 출력하고 싶으면 append('\n')을 추가
      static StringBuilder sb = new StringBuilder();

      public static void main(String[] args) {
          input();
      }
      static void input(){
        int[] remainders = new int[10];
        int count = 0;

        for (int i = 0; i < 10; i++) {
          int n = scan.nextInt();
          remainders[i] = n % 42;
        }

        for (int i = 0; i < remainders.length; i++) {
          for (int j = i; j < remainders.length; j++) {
            if (remainders[i] == remainders[j] && i != j) {
              count++;
              break; // 중복된 숫자 제거를 위해 중복된 숫자를 다음 숫자부터 찾아야하므로 반복문 종료.
            }
          }
        }

        System.out.println(remainders.length - count);
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