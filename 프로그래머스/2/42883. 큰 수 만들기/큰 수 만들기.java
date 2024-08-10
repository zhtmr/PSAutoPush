import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
          ArrayDeque<Character> stack = new ArrayDeque<>();

          for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k > 0) {
              stack.poll();
              k--;
            }
            stack.push(c);
          }


         for (int i = 0; i < k; i++) {
            stack.pop();
          }

          for (char c : stack) {
            sb.append(c);
          }

          return sb.reverse().toString();
        
    }
}