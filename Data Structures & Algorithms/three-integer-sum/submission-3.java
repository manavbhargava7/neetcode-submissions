class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /*
        1. brute force, go through each possible 3 pair
        2. make a hash map with all the duo sums, include their corresponding indicies. then loop through and find the target
        3. sort? for each value, do two pointers to find another set
            avoid duplicates
        */

        Arrays.sort(nums);

        HashSet<List<Integer>> ret = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            //two pointers
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = (nums[l] + nums[r]);
                if (sum + nums[i] > 0) {
                    r--;
                } else if (sum + nums[i] < 0) {
                    l++;
                } else {
                    ret.add(List.of(nums[i], nums[l], nums[r]));
                    if (nums[l + 1] == nums[l]) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }

        return new ArrayList<>(ret);
    }

}
