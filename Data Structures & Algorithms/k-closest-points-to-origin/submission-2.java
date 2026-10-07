class Solution {
    public int[][] kClosest(int[][] points, int k) {
        /*
        Given we 2d array of points and integer k, need to return k closest points to origin

        calculate distance for each point. sort distances, return k closest points

        need to map the distance to their points somehow
        */

        Arrays.sort(points, (int[] p1, int[] p2) -> distance(p1) -  distance(p2));

        int[][] kClosest = new int[k][2];
        for (int i = 0; i < k; i++) {
            kClosest[i] = points[i];
        }

        return kClosest;
    }

    private int distance(int[] p) {
        return (int)Math.pow(p[0], 2) + (int)Math.pow(p[1], 2);
    }
}
