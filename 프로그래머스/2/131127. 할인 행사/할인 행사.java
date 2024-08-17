import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
          map.put(want[i], number[i]);
        }

        HashMap<String, Integer> discountMap = null;
        for (int i = 0; i <= discount.length - 10; i++) {
          discountMap = new HashMap<>();
          for (int j = i; j < i + 10; j++) {
            discountMap.put(discount[j], discountMap.getOrDefault(discount[j], 0) + 1);
          }
          if (map.equals(discountMap)) {
            answer++;
          }
        }

        return answer;
    }
}