class Solution {
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        int n = nextVisit.length;
        long[] dp = new long[n];
        int mod = (int) 1e9 + 7;

        dp[0] = 0;  // 시작 방이기 때문에 첫날은 0

        for (int i = 1; i < n; i++) {
            dp[i] = (dp[i - 1] + 1 + dp[i - 1] - dp[nextVisit[i - 1]] + 1 + mod) % mod;
        }

        return (int) dp[n - 1];
    }
}