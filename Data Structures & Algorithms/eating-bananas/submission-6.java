class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //find smallest k
        //binary search
        int l = 1;
        int r = -1;

        for (int p : piles) {
            r = Math.max(r, p);
        }

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int hours = 0;
            
            for (int p : piles) {
                hours += Math.ceil((double) p / mid);
            }

            if (hours <= h) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l;

        //0, 1, 2 , 3, 4, 5, 6
    }

    //monotonic condition, if you can eat in h hours with k = m, you can eat in h hours with k = m + 1
}