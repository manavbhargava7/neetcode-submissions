class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> counts = new HashMap<>();

        for (int i : nums) {
            counts.put(i, counts.getOrDefault(i, 0) + 1);
        }

        List<Integer> vals = new ArrayList<>(counts.keySet());

        Collections.sort(vals, (v1, v2) -> Integer.compare(counts.get(v2), counts.get(v1)));

        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = vals.get(i);
        }

        return ret;
    }
}
