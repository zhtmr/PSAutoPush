import java.util.LinkedList;
import java.util.Queue;

public class Main {
    
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        
        System.out.println(bfs(n));
    }

    private static int bfs(int n) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        queue.add(new int[] { n, 0 });
        visited[n] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int number = current[0];
            int count = current[1];

            if (number == 1) {
                return count;
            }

            
            if (number % 3 == 0 && !visited[number / 3]) {
                queue.add(new int[] { number / 3, count + 1 });
                visited[number / 3] = true;
            }

            if (number % 2 == 0 && !visited[number / 2]) {
                queue.add(new int[] { number / 2, count + 1 });
                visited[number / 2] = true;
            }

            if (!visited[number - 1]) {
                queue.add(new int[] { number - 1, count + 1 });
                visited[number - 1] = true;
            }
        }

        return -1; 
    }
}