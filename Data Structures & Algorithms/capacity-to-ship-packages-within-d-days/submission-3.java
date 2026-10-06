class Solution {
    public int shipWithinDays(int[] weights, int days) {
        //are we guaranteed a solution?
        int l = Arrays.stream(weights).max().getAsInt();
        int r = Arrays.stream(weights).sum();

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int numDays = numDays(weights, mid);
            if (numDays == days) {
                r = mid - 1;
            } else if (numDays < days) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    private int numDays(int[] weights, int weight) {
        int days = 1;

        int curr = weight;

        int i = 0;
        
        while (i < weights.length) {
            if (curr >= weights[i]) {
                curr-= weights[i];
                i++;
            } else {
                days++;
                curr = weight;
            }
        }

        return days;
    }
}