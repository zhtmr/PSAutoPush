import java.util.*;

class Solution {
   public static class Point {
    public final long x, y;

    public Point(long x, long y) {
      this.x = x;
      this.y = y;
    }
  }

  private Point intersection(long a1, long b1, long c1, long a2, long b2, long c2) {
    double x = (double) (b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1);
    double y = (double) (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1);

    // 정수만
    if (x % 1 != 0 || y % 1 != 0) return null;
    return new Point((long) x, (long) y);
  }

  private Point getMinPoint(List<Point> points) {
    long x = Long.MAX_VALUE;
    long y = Long.MAX_VALUE;

    for (Point p : points) {
      if (p.x < x) x = p.x;
      if (p.y < y) y = p.y;
    }
    return new Point(x, y);
  }

  private Point getMaxPoint(List<Point> points) {
    long x = Long.MIN_VALUE;
    long y = Long.MIN_VALUE;

    for (Point p : points) {
      if (p.x > x) x = p.x;
      if (p.y > y) y = p.y;
    }
    return new Point(x, y);
  }

  public String[] solution(int[][] line) {
    List<Point> points = new ArrayList<>();
    for (int i = 0; i < line.length; i++) {
      for (int j = i + 1; j < line.length; j++) {
        Point intersection = intersection(line[i][0], line[i][1], line[i][2],
                                          line[j][0], line[j][1], line[j][2]);
        if (intersection != null) points.add(intersection);
      }
    }

    Point minPoint = getMinPoint(points);
    Point maxPoint = getMaxPoint(points);

    int width = (int) (maxPoint.x - minPoint.x + 1);
    int height = (int) (maxPoint.y - minPoint.y + 1);

    char[][] arr = new char[height][width];
    Arrays
        .stream(arr)
        .forEach(rows -> Arrays.fill(rows, '.'));

    for (Point p : points) {
      int x = (int) (p.x - minPoint.x);
      int y = (int) (maxPoint.y - p.y);
      arr[y][x] = '*';
    }

    String[] result = new String[arr.length];
    for (int i = 0; i < result.length; i++) {
      result[i] = new String(arr[i]);
    }

    return result;
  }
}