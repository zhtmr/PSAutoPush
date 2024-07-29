import java.util.*;

class Solution {
    boolean solution(String s) {
       

        return extracted(s);
    }
    
    private static boolean extracted(String s) {
        char[] charArray = s.toCharArray();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c : charArray) {
          if (c == '(') {
            stack.push(c);
          } else if (c == ')') {
            if (stack.isEmpty()) {
              return false;
            }
            stack.pop();
          }
        }

        return stack.isEmpty();
  }
}