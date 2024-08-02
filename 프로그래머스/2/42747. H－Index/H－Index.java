import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        int[] counts = new int[n + 1];

        // 인용 횟수를 카운트
        for (int c : citations) {
            if (c >= n) {
                counts[n]++;
            } else {
                counts[c]++;
            }
        }

        // H-Index 계산
        int total = 0;
        for (int i = n; i >= 0; i--) {
            total += counts[i];
            if (total >= i) {
                return i;
            }
        }

        return 0;
    }
}