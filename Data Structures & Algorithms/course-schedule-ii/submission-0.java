class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        /*
        Prereq (a, b), means b -> a

        numCourses courses

        create a graph from node to edges 

        calculate indegree, do kahns algorithm

        keep an int array of order and a counter

        if counter = numCourses, return int[] otherwise return empty arr
        */

        //make graph
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); //course id -> list of its retrievable edges
        int[] inDegree = new int[numCourses]; //number of incoming edges

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>()); //initialize
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int[] edge = prerequisites[i];
            graph.get(edge[1]).add(edge[0]);

            inDegree[edge[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;
        int[] order = new int[numCourses];

        while (!q.isEmpty()) {
            int n = q.size();
            
            for (int i = 0; i < n; i++) {
                int curr = q.poll();
                order[count] = curr;
                count++;
                
                //decrement degree of all its edges
                ArrayList<Integer> edges = graph.get(curr);

                for (int e : edges) {
                    inDegree[e]--;
                    if (inDegree[e] == 0) {
                        q.offer(e);
                    }
                }
            }
        }

        if (count == numCourses) {
            return order;
        }
        return new int[0];
    }
}
