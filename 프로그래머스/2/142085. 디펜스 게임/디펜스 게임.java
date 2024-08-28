import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    for (int i = 0; i < enemy.length; i++) {
      maxHeap.add(enemy[i]);
      n -= enemy[i];

      if (n < 0) {
        if (k > 0) {
          n += maxHeap.poll();
          k--;
        } else {
          break;
        }
      }
      answer++;
    }
        return answer;
    }
}