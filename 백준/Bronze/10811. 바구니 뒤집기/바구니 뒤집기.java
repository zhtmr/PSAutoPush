import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        int n = scan.nextInt();
        int m = scan.nextInt();

        int[] arr = new int[n + 1];

        for (int k = 1; k <= n; k++) {
          arr[k] = k;
        }
//        System.out.println("원본:       "+Arrays.toString(arr));

        for (int z = 0; z < m; z++) {
          int i = scan.nextInt();
          int j = scan.nextInt();
          int T = j-i;
          int[] tmpArr = new int[arr.length];

          for (int c = 0; c <= T; c++, j--, i++) {
            tmpArr[i] = arr[j];
          }

//          System.out.println("tmpArr: "+Arrays.toString(tmpArr));
          for (int k = 0; k < tmpArr.length; k++) {
            if (tmpArr[k] != 0) {
              arr[k] = tmpArr[k];
            }
          }

        }
//        System.out.println("결과: "+Arrays.toString(arr));
        System.out.println(Arrays.toString(arr).replace("[","").replace("]","").replace(",","").substring(2));



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