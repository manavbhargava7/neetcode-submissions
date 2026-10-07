class KthLargest {

    PriorityQueue<Integer> h;
    int size;

    public KthLargest(int k, int[] nums) {
        h = new PriorityQueue<>();
        size = k;

        for (int i : nums) {
            add(i);
        }

    }
    
    public int add(int val) {
        h.offer(val);
        if (h.size() > size) {
            h.poll();
            return h.peek();
        } 

        return h.peek();
    }
}
