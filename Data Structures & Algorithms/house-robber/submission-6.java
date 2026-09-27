class Solution {
    public int rob(int[] nums) {
        
        // nums[i] = Math.max(nums[i - 2], nums[i - 3]) + nums[i]

        int[] dp = new int[nums.length + 2];
        int max = -1;

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 2]);
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
