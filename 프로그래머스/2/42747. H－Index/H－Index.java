import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Integer[] array = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(array, Collections.reverseOrder());
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= i + 1) {
              answer = i + 1;  
            } else {
                break;
            }
        }
        return answer;
    }
}