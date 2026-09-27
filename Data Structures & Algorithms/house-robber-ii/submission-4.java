class Solution {
    int[] memo;

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        int take1 = dfs(nums, 0);
        
        Arrays.fill(memo, -1);
        memo[0] = 0;
        int take2 = dfs2(nums, 1);

        return Math.max(take1, take2);
    }

    private int dfs(int[] nums, int i) {
        if (i >= nums.length - 1) {
            return 0;
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        memo[i] = Math.max(nums[i] + dfs(nums, i + 2), dfs(nums, i + 1));
        return memo[i];
    }

    private int dfs2(int[] nums, int i) {
        if (i >= nums.length) {
            return 0;
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        System.out.println(i);

        memo[i] = Math.max(dfs2(nums, i + 1), nums[i] + dfs2(nums, i + 2));
        return memo[i];
    }
}
