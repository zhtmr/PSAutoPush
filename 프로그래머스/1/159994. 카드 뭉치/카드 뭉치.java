import java.util.*;

class Solution {
    
    private static String check(Queue<String> card1Queue, Queue<String> card2Queue, Queue<String> goalQ) {
        while (!goalQ.isEmpty()) {
            
          if (!card1Queue.isEmpty() && card1Queue.peek().equals(goalQ.peek())) {
            card1Queue.poll();
            goalQ.poll();
          } else if (!card2Queue.isEmpty() && card2Queue.peek().equals(goalQ.peek())) {
            card2Queue.poll();
            goalQ.poll();
          } else {
            return "No";
          }
        }
        return "Yes";
      }
    
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        Queue<String> card1Queue = new ArrayDeque<>(List.of(cards1));
        Queue<String> card2Queue = new ArrayDeque<>(List.of(cards2));
        Queue<String> goalQ = new ArrayDeque<>(List.of(goal));
        
        return check(card1Queue, card2Queue, goalQ);
    }
    
    
}