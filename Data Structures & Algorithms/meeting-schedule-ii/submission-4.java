/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.size() == 0) {
            return 0;
        }

        Collections.sort(intervals, (i1, i2) -> Integer.compare(i1.start, i2.start));

        int i = 0; 
        //know when room ends
        int rooms = 1;
        PriorityQueue<Integer> endTimes = new PriorityQueue<>();

        while (i < intervals.size() - 1) {
            endTimes.add(intervals.get(i).end);
            if (intervals.get(i+1).start < intervals.get(i).end) {
                //we have an overlap!
                while (endTimes.peek() <= intervals.get(i + 1).start) {
                    endTimes.remove();
                }

                if (endTimes.size() == rooms) {
                    rooms++;
                }
            }
            i++;
        }

        return rooms;
    }
}
