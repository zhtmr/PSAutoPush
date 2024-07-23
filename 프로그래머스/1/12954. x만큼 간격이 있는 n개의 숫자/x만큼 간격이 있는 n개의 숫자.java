class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long j = x;
        for (int i = 0; i < n; i++, j+= x) {
          answer[i] = j;
        }
        return answer;
    }
}