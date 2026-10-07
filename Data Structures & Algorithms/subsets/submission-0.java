class Solution {
    ArrayList<List<Integer>> ret = new ArrayList<>();
    int[] nums;


    public List<List<Integer>> subsets(int[] nums) {
        //at each index, you can choose to either select ehe element or dont select. recurse across the entire nums array to find all values
        this.nums = nums;
        findCurr(0, new ArrayList<>());
        return ret;

    }

    private void findCurr(int index, ArrayList<Integer> curr) {
        if (index == nums.length) {
            List<Integer> l = new ArrayList<>(curr);
            ret.add(l);
            return;
        }

        curr.add(nums[index]);
        findCurr(index + 1, curr);

        curr.remove(curr.size() - 1);
        findCurr(index + 1, curr);
    }
}
