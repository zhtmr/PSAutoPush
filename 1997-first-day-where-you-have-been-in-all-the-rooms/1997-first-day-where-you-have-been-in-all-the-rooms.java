class Solution {
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        int n = nextVisit.length;
        long[] dp = new long[n];
        int mod = (int) 1e9 + 7;

        dp[0] = 0;  // 시작 방이기 때문에 첫날은 0

        for (int i = 1; i < n; i++) {
            // dp[i] = 이전 방까지 걸린 시간 + 현재 방에 도착하는 시간 + 다시 돌아가는 시간
            dp[i] = (dp[i-1] * 2 - dp[nextVisit[i-1]] + 2 + mod) % mod;
        }

        return (int) dp[n - 1];
    }
}