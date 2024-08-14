import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<Character, Integer> map = new HashMap<>();
        for (String s : keymap) {
          char[] charArray = s.toCharArray();
          for (int j = 0; j < charArray.length; j++) {
            char c = charArray[j];
            if (map.get(c) == null || map.get(c) > j) {
              map.put(c, j + 1);
            }
          }
        }

        for (int i = 0; i < targets.length; i++) {
          char[] charArray = targets[i].toCharArray();
          for (int j = 0; j < charArray.length; j++) {
            char c = charArray[j];
            if (map.containsKey(c)) {
              answer[i] += map.get(c);
            } else {
              answer[i] = -1;
              break;
            }
          }
        }
        return answer;
    }
}