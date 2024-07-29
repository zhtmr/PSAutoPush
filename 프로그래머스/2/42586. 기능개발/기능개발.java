import java.util.*;


class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        List<Integer> days = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
          int v = (int) Math.ceil((100 - (double) progresses[i]) / (double) speeds[i]);
          days.add(v);
        }


        ArrayList<Integer> result = new ArrayList<>();
        int count = 1;
        int prev = days.get(0);

        for (int i = 1; i < days.size(); i++) {
          if (prev >= days.get(i)) {
            count++;
          } else {
            result.add(count);
            count = 1;
            prev = days.get(i);
          }
        }
        result.add(count);

        
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
          answer[i] = result.get(i);
        }
        
        return answer;

    }
}