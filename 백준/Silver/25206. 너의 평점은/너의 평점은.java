import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

  static FastReader scan = new FastReader();
  //정답은 sb에 append 를 사용하여 출력
  //만약 개행까지 출력하고 싶으면 append('\n')을 추가
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    String[] grade = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F"};
    float[] score = {4.5F, 4.0F, 3.5F, 3.0F, 2.5F, 2.0F, 1.5F, 1.0F, 0};
    float sum = 0;
    float total = 0;

    for (int i = 0; i < 20; i++) {
      String s = scan.nextLine();
      String[] st = s.split(" ");
      int index = 0;
      if (st[2].equals("P")) {
        continue;
      }
      for (int j = 0; j < grade.length; j++) {
        if (st[2].equals(grade[j])) {
          index = j;
        }
      }
      sum += Float.parseFloat(st[1]) * score[index];
      total += Float.parseFloat(st[1]);
    }
    System.out.println(sum / total);
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