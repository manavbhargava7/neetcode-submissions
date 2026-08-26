class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        /*
        Task: given intervals

        return smallest number of intervals to remove to make rest of intervals non overlapping

        Implementation
        1. Sort intervals
        2. if overlap, eliminate option with most overlapping intervals
        3. continue until current has no overlap, continue forward

        Approach 1:
        1. sort intervals, recursively explore all possibilities

        */

        Arrays.sort(intervals, (v1, v2) -> {
            int val = Integer.compare(v1[0], v2[0]);
            if (val == 0) {
                return Integer.compare(v2[1], v1[1]);
            }
            return val;
    });

        //form hashmap


        int i = 0; 
        int count = 0;
        while (i < intervals.length - 1) {
            //look at two intervals, if no overlap, continue
            if (intervals[i + 1][0] < intervals[i][1]) {
                //at this point there is an overlap
                count++;
                intervals[i + 1][1] = Math.min(intervals[i][1], intervals[i + 1][1]);
            }
            i++;
        }

        return count;
        //identify all overlaps for each interval


        //eliminate highest count interval




    }
}
