import java.util.*;
class Solution {
    public int solution(String s) {
    int answer = 0;
    for (int i = 0; i < s.length(); i++) {
      String s1 = s.substring(i) + s.substring(0, i);
      if (check(s1)) {
        answer++;
      }
    }
    return answer;
  }

  boolean check(String s) {
    ArrayDeque<Character> stack = new ArrayDeque<>();
    char[] charArray = s.toCharArray();
    for (char ch : charArray) {
      if (ch == '(' || ch == '[' || ch == '{') {
        stack.push(ch);
      } else if (ch == ')') {
        if (stack.isEmpty() || !stack.pop().equals('(')) {
          return false;
        }
      } else if (ch == ']') {
        if (stack.isEmpty() || !stack.pop().equals('[')) {
          return false;
        }
      } else if (ch == '}') {
        if (stack.isEmpty() || !stack.pop().equals('{')) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }
}