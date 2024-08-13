class Solution {
    public int solution(int storey) {
        int answer;
        if (storey <= 5) {
          return storey;
        } else if (storey < 10) {
          return 11 - storey;
        }

        int lastNum = storey % 10;
        int down = solution(storey / 10) + lastNum;
        int up = solution(storey / 10 + 1) + (10 - lastNum);
        answer = Math.min(down, up);

        return answer;
        
        
    }
}