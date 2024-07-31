import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (String command : operations) {
          if (command.contains("I")) {
            maxHeap.add(Integer.valueOf(command.split(" ")[1]));
            minHeap.add(Integer.valueOf(command.split(" ")[1]));
          } else if (command.equals("D 1")) {
            minHeap.remove(maxHeap.poll());
          } else {
            maxHeap.remove(minHeap.poll());
            
          }
        }


        int[] result = new int[2];
        result[0] = maxHeap.peek() == null ? 0 : maxHeap.peek();
        result[1] = minHeap.peek() == null ? 0 : minHeap.peek();
        return result;
    }
}