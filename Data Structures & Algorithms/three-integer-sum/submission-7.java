class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /*
        1. brute force, go through each possible 3 pair
        2. make a hash map with all the duo sums, include their corresponding indicies. then loop through and find the target
        3. sort? for each value, do two pointers to find another set
            avoid duplicates
        */

        Arrays.sort(nums);

        List<List<Integer>> ret = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            //two pointers
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
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
                    while (l + 1 < r && nums[l] == nums[l+1]) {
                        l++;
                    }

                    while (r - 1> l && nums[r] == nums[r-1]) {
                        r--;
                    }
                    l++;
                    r--;
                }
            }
        }

        return ret;
    }

}
