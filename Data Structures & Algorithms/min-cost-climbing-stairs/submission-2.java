class Solution {
    public int minCostClimbingStairs(int[] cost) {
        /*
        Bottom up dp:

        */

        int[] table = new int[cost.length];

        table[0] = 0;
        table[1] = 0;

        for (int i = 2; i < cost.length; i++) {
            table[i] = Math.min(table[i - 1] + cost[i - 1], table[i - 2] + cost[i - 2]);

        }

        return Math.min(table[cost.length - 1] + cost[cost.length - 1], table[cost.length - 2] + cost[cost.length - 2]);
    }
}
