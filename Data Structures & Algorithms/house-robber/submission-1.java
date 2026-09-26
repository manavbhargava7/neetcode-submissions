class Solution {
    int[] memo;
    public int rob(int[] nums) {
        /*
        At each stage, you have the choice to either rob this house, or the house after

        you can never negative rob

        no need to rob the first house, so you can set those to be 0

        9, 3
        9, 6

        2, 8, 6

        2, 3

        1. recursion, 
        - choose to rob either i + 2 or i + 3
        - 2 ^ n
        - evaluate both choices, return max of both

        2. recursion (bottom up with memoization)
        - store the values of saved calcs
        - reduce to o of n

        3. tabular?
        - max money up to that point
        - Math.max (dp[i - 2], dp[i - 3]) + nums[i]
        */
        int[] newNums = new int[nums.length + 2];
        for (int i = 0; i < nums.length; i++) {
            newNums[i + 2] = nums[i];
        }
        memo = new int[newNums.length];
        Arrays.fill(memo, -1);

        //has the two zero padding at the front
        return dfs(newNums, 0);
    }

    private int dfs(int[] nums, int i) {
        if (i >= nums.length) {
            return 0;
        }
        if (i == nums.length - 1) {
            return nums[i];
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        memo[i] = Math.max(dfs(nums, i + 2), dfs(nums, i + 3)) + nums[i];

        return memo[i];
    }
}
