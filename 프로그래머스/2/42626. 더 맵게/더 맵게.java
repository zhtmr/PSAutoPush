import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int j : scoville) {
            minHeap.add(j);
        }

        return getInteger(minHeap, K);

    }

    private Integer getInteger(PriorityQueue<Integer> minHeap, int K) {
        int count = 0;

        while (minHeap.peek() < K) {
            if (minHeap.size() <= 1) {
                count = -1;
                break;
            }
            Integer firstMin = minHeap.poll();
            Integer secondMin = minHeap.poll();
            int newScoville = firstMin + (secondMin * 2);
            minHeap.add(newScoville);
            count++;

        }
        return count;

    }
}
