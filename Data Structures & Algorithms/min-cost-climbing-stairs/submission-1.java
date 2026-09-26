class Solution {
    int[] currCost;

    public int minCostClimbingStairs(int[] cost) {
        //aim is to get past the last index in cost

        /*
        Implementations:
        1. recursive, evaluate all options, maintain cost, return min cost
        2. top down dp -> recursive + memoization
        3. bottom up dp -> tabulation
        - build table where each index represents min cost to get here

        repetitive problems. at every step you ask is it better to move to i + 1 or the i + 2 floor

        //cost.length >= 2
        can start at either index 0 or 1
        */

        //0 -> 1st step
        //0 -> 2nd step
        //

        // int[] currCost = new int[n + 1];

        // currCost[0] = 0; //represents cost to jump from beginning

        // for (int i = 0; i < cost.length) {
        //     currCost[i]
        // }
        currCost = new int[cost.length];
        Arrays.fill(currCost, -1);

        return dfs(cost, cost.length);


    }

    private int dfs(int[] cost, int i) {
        if (i < 2) {
            return cost[i];
        }
        if (i == cost.length) {
            return Math.min(dfs(cost, i - 1), dfs(cost, i - 2));
        }

        if (currCost[i] != -1) {
            return currCost[i];
        }

        currCost[i] = Math.min(dfs(cost, i - 1), dfs(cost, i - 2)) + cost[i];

        return currCost[i];
    }
}
