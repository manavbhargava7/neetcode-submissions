class Solution {
    public int[][] merge(int[][] intervals) {
        /*
        Implementation:

        1. sort intervals by first number, if i2 n1 is less than or equal to i1n2, it overlaps, so then merge. continue for next

        */

        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        //now you have an array sorted by first index

        //output
        ArrayList<int[]> res = new ArrayList<>(); 
        int i = 0;
        while (i < intervals.length) {
            if (i == intervals.length - 1) {
                res.add(intervals[i]);
                i++;
                continue;
            }

            int[] i1 = intervals[i];
            int[] i2 = intervals[i + 1];

            if (i2[0] <= i1[1]) {
                intervals[i + 1][0] = intervals[i][0];              
                intervals[i + 1][1] = Math.max(intervals[i][1], intervals[i + 1][1]);             
                while ((i < intervals.length - 1) && intervals[i + 1][0] <= intervals[i][1]) {
                    intervals[i + 1][0] = intervals[i][0];              
                    intervals[i + 1][1] = Math.max(intervals[i][1], intervals[i + 1][1]);
                    i++;
                }
            } 
            res.add(intervals[i]);
            i++;
        }

        //convert to int[]
        int[][] r = new int[res.size()][];

        for (int j = 0; j < res.size(); j++) {
            r[j] = res.get(j);
        }

        return r;


    }
}
