class Solution {
    public int climbStairs(int n) {
        int prev = 1;
        int curr = 1;
        int next = 1;
        
        for (int i = 1; i < n; i++) {
            next = prev + curr;
            prev = curr;
            curr = next;
        }

        return next;
    }
}
