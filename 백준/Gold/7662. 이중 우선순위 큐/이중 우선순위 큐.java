import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine());
            PriorityQueue<Node> minHeap = new PriorityQueue<>();
            PriorityQueue<Node> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            boolean[] visited = new boolean[k];
            
            for (int i = 0; i < k; i++) {
                String[] command = br.readLine().split(" ");
                char op = command[0].charAt(0);
                int num = Integer.parseInt(command[1]);
                
                if (op == 'I') {
                    // 삽입
                    Node node = new Node(num, i);
                    minHeap.offer(node);
                    maxHeap.offer(node);
                    visited[i] = true;
                } else if (op == 'D') {
                    // 삭제
                    if (num == 1) {
                        // 최대값 삭제
                        while (!maxHeap.isEmpty() && !visited[maxHeap.peek().index]) {
                            maxHeap.poll();
                        }
                        if (!maxHeap.isEmpty()) {
                            visited[maxHeap.poll().index] = false;
                        }
                    } else if (num == -1) {
                        // 최소값 삭제
                        while (!minHeap.isEmpty() && !visited[minHeap.peek().index]) {
                            minHeap.poll();
                        }
                        if (!minHeap.isEmpty()) {
                            visited[minHeap.poll().index] = false;
                        }
                    }
                }
            }
            
            // 결과 출력
            while (!minHeap.isEmpty() && !visited[minHeap.peek().index]) {
                minHeap.poll();
            }
            while (!maxHeap.isEmpty() && !visited[maxHeap.peek().index]) {
                maxHeap.poll();
            }
            
            if (minHeap.isEmpty() || maxHeap.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(maxHeap.peek().value).append(" ").append(minHeap.peek().value).append("\n");
            }
        }
        
        System.out.print(sb.toString());
    }

    // 우선순위 큐에 들어갈 노드 클래스
    static class Node implements Comparable<Node> {
        int value;
        int index;
        
        Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
        
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.value, other.value);
        }
    }
}