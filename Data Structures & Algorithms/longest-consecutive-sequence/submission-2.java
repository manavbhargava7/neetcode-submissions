class Solution {
    public int longestConsecutive(int[] nums) {
        //find max and min, count up, 

        //cannot sort, as we need O(n)


        //Implementations
        /*
        1. Sort, find consecutive -> o(nlogn)
        2. add to a set, use that to check if n+1 exists
        */

        Set<Integer> s = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            s.add(nums[i]);
        }

        int longestCount = 0;

        //to reduce repetitive computation, can use hashmap from value to count


        for (int i : s) {
            if (s.contains(i-1)) {
                continue;
            }

            int currCount = 1;
            i++;
            while (s.contains(i)) {
                currCount++;
                i++;
            }
            
            longestCount = Math.max(longestCount, currCount);
        }

        return longestCount;
    }
}
