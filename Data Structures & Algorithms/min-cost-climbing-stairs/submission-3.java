class Solution {
    public int minCostClimbingStairs(int[] cost) {
        /*
        Bottom up dp:

        */

        int prev = 0;
        int curr = 0;

        for (int i = 2; i < cost.length; i++) {
            int next = Math.min(curr + cost[i - 1], prev + cost[i - 2]);
            prev = curr;
            curr = next;

        }

        return Math.min(curr + cost[cost.length - 1], prev + cost[cost.length - 2]);
    }
}
