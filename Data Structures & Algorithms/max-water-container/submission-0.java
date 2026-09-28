class Solution {
    public int maxArea(int[] heights) {
        //two pointers

        //can store the min of height * l - r

        int maxWater = 0;
        int l = 0;
        int r = heights.length - 1;

        while (l < r) {
            int currWater = Math.min(heights[l], heights[r]) * (r - l);
            maxWater = Math.max(maxWater, currWater);

            //do i move l or r
            //greedily move the one with the lower min to the next index
            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }

        return maxWater;
    }
}
