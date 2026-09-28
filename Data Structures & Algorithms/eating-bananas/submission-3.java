class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //find smallest k
        //binary search
        int l = 1;
        int r = -1;

        for (int p : piles) {
            r = Math.max(r, p);
        }

        while (l < r) {
            int mid = l + (r - l) / 2;
            int count = numCountBananas(piles, mid);
            if (count < h) {
                r = mid;
            } else if (count > h){
                l = mid + 1;
            } else {
                //found a k that finishes in h hours
                //need the smallest one possible 
                r = mid;
            }
        }

        return l;

        //0, 1, 2 , 3, 4, 5, 6
    }

    //monotonic condition, if you can eat in h hours with k = m, you can eat in h hours with k = m + 1

    public int numCountBananas(int[] piles, int k) {
        int hours = 0;
        
        for (int p : piles) {
            hours += Math.ceil((double) p / k);
        }

        return hours;
    }
}