class Solution {
    public int maxProfit(int[] prices) {
        /*
        Case 1: Strictly decreasing -> do not buy
        Case 2: Strictly Increasing -> buy on day 1
        Case 3: middle

        if right pointer is less than left, move it there

        */

        int l = 0;
        int r = 1;

        int maxProfit = 0;

        while (r < prices.length) {
            if (prices[r] < prices[l]) {
                l = r;
            } else {
                int profit = prices[r] - prices[l];
                maxProfit = Math.max(profit, maxProfit);
            }
            r++;
        }
        return maxProfit;
    }
}
