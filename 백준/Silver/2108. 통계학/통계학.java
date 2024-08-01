import java.io.*;
import java.util.*;

public class Main {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
  }

  static void input() {
    int N = scan.nextInt();
    int[] ints = new int[N];
    for (int i = 0; i < N; i++) {
      ints[i] = scan.nextInt();
    }

    Arrays.sort(ints);
    int sum = 0;
    for (int anInt : ints) {
      sum += anInt;
    }

    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < N; i++) {
      int key = ints[i];
      map.put(key, map.getOrDefault(key, 0) + 1);
    }

//    System.out.println("map = " + map);

    long avg = Math.round((double) sum / N);
    int mid = ints[N / 2];
    int mode = 0;
    int range = Math.abs(ints[ints.length - 1] - ints[0]);

    int max = Integer.MIN_VALUE;
    ArrayList<Integer> modeCandidates = new ArrayList<>();
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      Integer count = entry.getValue();
      if (count > max) {
        max = count;
        modeCandidates.clear();
        modeCandidates.add(entry.getKey());
      } else if (max == count) {
        modeCandidates.add(entry.getKey());
      }
    }

    Collections.sort(modeCandidates);
    if (modeCandidates.size() > 1) {
      mode = modeCandidates.get(1);
    } else {
      mode = modeCandidates.get(0);
    }

    System.out.println(avg);
    System.out.println(mid);
    System.out.println(mode);
    System.out.println(range);

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