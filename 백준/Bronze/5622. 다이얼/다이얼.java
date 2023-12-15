import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
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
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int t = 0;

        for (int i = 0; i < s.length(); i++) {
          char c = s.charAt(i);
          if ("ABC".contains(String.valueOf(c))) {
            t += 3;
          } else if ("DEF".contains(String.valueOf(c))) {
            t += 4;
          } else if ("GHI".contains(String.valueOf(c))) {
            t += 5;
          } else if ("JKL".contains(String.valueOf(c))) {
            t += 6;
          } else if ("MNO".contains(String.valueOf(c))) {
            t += 7;
          } else if ("PQRS".contains(String.valueOf(c))) {
            t += 8;
          } else if ("TUV".contains(String.valueOf(c))) {
            t += 9;
          } else if ("WXYZ".contains(String.valueOf(c))) {
            t += 10;
          }
        }

        System.out.println(t);
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