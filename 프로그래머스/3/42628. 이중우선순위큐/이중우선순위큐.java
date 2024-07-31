import java.util.*;

 class Node implements Comparable<Node> {
    int value;
    int index;

    Node(int value, int index) {
      this.value = value;
      this.index = index;
    }

    @Override
    public int compareTo(Node o) {
      return Integer.compare(this.value, o.value);
    }
  }

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        PriorityQueue<Node> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        boolean[] visited = new boolean[operations.length];


        for (int i = 0, len = operations.length; i < len; i++) {
          String command = operations[i];
          if (command.contains("I")) {
            int num = Integer.parseInt(command.split(" ")[1]);
            Node node = new Node(num, i);
            maxHeap.add(node);
            minHeap.add(node);
            visited[i] = true;
          } else if (command.equals("D 1")) {
            while (!maxHeap.isEmpty() && !visited[maxHeap.peek().index]) {
              maxHeap.poll();
            }
            if (!maxHeap.isEmpty()) {
              visited[maxHeap.poll().index] = false;
            }
          } else {
            while (!minHeap.isEmpty() && !visited[minHeap.peek().index]) {
              minHeap.poll();
            }
            if (!minHeap.isEmpty()) {
              visited[minHeap.poll().index] = false;
            }
          }
        }
        
        while (!minHeap.isEmpty() && !visited[minHeap.peek().index]) {
          minHeap.poll();
        }
        while (!maxHeap.isEmpty() && !visited[maxHeap.peek().index]) {
          maxHeap.poll();
        }

        int[] result = new int[2];
        if (minHeap.isEmpty() || maxHeap.isEmpty()) {
          result[0] = 0;
          result[1] = 0;
        } else {
          result[0] = maxHeap.peek().value;
          result[1] = minHeap.peek().value;
        }
        return result;
    }
}