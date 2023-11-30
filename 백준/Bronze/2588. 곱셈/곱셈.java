import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    int value_3;
    int value_4;
    int value_5;
    int value_6;

    Scanner scanner = new Scanner(System.in);

    int A = valid(scanner.nextInt(), scanner);
    int B = valid(scanner.nextInt(), scanner);

    int[] parsed_B = parse(B);

    value_3 = A * parsed_B[2];
    value_4 = A * parsed_B[1];
    value_5 = A * parsed_B[0];
    value_6 = A * B;
    System.out.println(value_3);
    System.out.println(value_4);
    System.out.println(value_5);
    System.out.println(value_6);


    scanner.close();
  }

  private static int[] parse(int num) {
    int num_100 = num / 100;
    int num_10 = num % 100 / 10;
    int num_1 = num % 10;
    return new int[] {num_100,num_10,num_1};
  }

  static int valid(int a, Scanner scanner) {
    int length = String.valueOf(a).length();
    boolean check = length == 3;
    int i = a;
    if (!check) {
      System.out.print("다시입력 > ");
      i = scanner.nextInt();
      return valid(i, scanner);
    }
    return i;
  }



}