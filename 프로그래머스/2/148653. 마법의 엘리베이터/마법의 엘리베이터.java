class Solution {
    public int solution(int storey) {
        int answer = 0;
        while (storey > 0) {
          int lastNum = storey % 10;
          if (lastNum > 5 || (lastNum == 5 && (storey / 10) % 10 >= 5)) {
            answer += (10 - lastNum);
            storey += (10 - lastNum);
          } else {
            answer += lastNum;
          }
          storey /= 10;
        }
        return answer;
    }
}