class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((int[] p1, int[] p2) -> Double.compare(distance(p2), distance(p1)));

        for (int[] p : points) {
            maxHeap.offer(p);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] kClosest = new int[k][2];

        for (int i = 0; i < k; i++) {
            kClosest[i] = maxHeap.poll();
        }

        return kClosest;
    }

    private double distance(int[] p) {
        return Math.sqrt(Math.pow(p[0], 2) + Math.pow(p[1], 2));
    }
}
