class Solution {
    public int rob(int[] nums) {
        
        // nums[i] = Math.max(nums[i - 2], nums[i - 3]) + nums[i]

        int rob1 = 0;
        int rob2 = 0;

        for (int i = 0; i < nums.length; i++) {
            int next = Math.max(rob1, rob2 + nums[i]);
            rob2 = rob1;
            rob1 = next;
        }

        return rob1;
    }
}
