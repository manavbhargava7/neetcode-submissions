class Solution {
    public int lastStoneWeight(int[] stones) {
        //need to select the heaviest stones at each step
        //repeatedly smash two heaviest, place remainder back into array
        //continue until array size is not more than 1, ret 0 if none remain


        //arrays do not dynamically rearrange, so you need a data structure

        //max heap will keep largest it at the top

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i : stones) {
            maxHeap.offer(i);
        }

        //now repeatedly smash

        while (maxHeap.size() > 1) {
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();

            if (stone1 != stone2) {
                maxHeap.offer(stone1 - stone2);
            }
        }

        if (maxHeap.size() == 1) {
            return maxHeap.peek();
        }
        return 0;
    }
}
