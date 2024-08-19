class Solution {
    public int lengthOfLIS(int[] nums) {
       int answer = 0;
        int[] dp = new int[nums.length + 1];

        for(int i = 0; i < nums.length; i++) {
          dp[i] = 1;
          for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
              if (dp[i] < dp[j] + 1) {
                dp[i] = dp[j] + 1;
              }
            }
          }
          answer = Math.max(answer, dp[i]);

        }
        return answer;
    }
}