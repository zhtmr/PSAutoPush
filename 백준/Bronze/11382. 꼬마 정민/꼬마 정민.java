import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    long a = Long.parseLong(scanner.next());
    long b = Long.parseLong(scanner.next());
    long c = Long.parseLong(scanner.next());




    System.out.println(a+b+c);
    scanner.close();
  }
}