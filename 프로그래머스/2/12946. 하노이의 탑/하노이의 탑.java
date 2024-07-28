import java.util.*;

class Solution {
    int index = 0;
    int[][] answer;
    
    public int[][] solution(int n) {
        answer = new int[(int) (Math.pow(2, n) - 1)][2];
        hanoi(n, 1, 3, 2);
        
        return answer;
    }
    
    void hanoi(int n, int start, int end, int tmp) {
        if (n == 1) {
            record(start, end);
            return;
        }
        hanoi(n-1, start, tmp, end);
        record(start, end);
        hanoi(n-1, tmp, end, start);
    }
    
    void record(int start, int end) {
        answer[index][0] = start;
        answer[index][1] = end;
        index++;
    }
}