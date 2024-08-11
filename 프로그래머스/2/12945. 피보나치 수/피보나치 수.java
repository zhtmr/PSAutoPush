class Solution {
    public int solution(int n) {
        int answer = 0;
        int MOD = 1234567;

        int[] dp = new int[1000001];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
          dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }

        answer = dp[n] % MOD;
        return answer;
    }
}