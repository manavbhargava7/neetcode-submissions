class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> counts = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            counts.put(nums[i], counts.getOrDefault(nums[i], 0) + 1);
        }

        //now you have the counts, top k makes me think of a heap

        PriorityQueue<int[]> p = new PriorityQueue<>((v1, v2) -> Integer.compare(v2[0], v1[0]));

        for (int i : counts.keySet()) {
            p.add(new int[]{counts.get(i), i});
        }

        //we now have a priority queue

        int[] ret = new int[k];

        for (int i = 0; i < k; i++) {
            ret[i] = p.poll()[1];
        }

        return ret;
    }
}
