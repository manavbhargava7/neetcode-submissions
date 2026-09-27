class Solution {
    public int rob(int[] nums) {
        
        // nums[i] = Math.max(nums[i - 2], nums[i - 3]) + nums[i]

        int[] dp = new int[nums.length + 3];
        int max = -1;

        for (int i = 3; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i - 3];
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
