class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //kahns algorithm 

        /*

        build a graph out with ad


        */

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int[] edge = prerequisites[i];
            adjList.get(edge[1]).add(edge[0]);

            inDegree[edge[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        int count = 0;

        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                int c = q.poll();
                System.out.println(c);
                count++;
                ArrayList<Integer> edges = adjList.get(c);
                for (int j = 0; j < edges.size(); j++) {
                    inDegree[edges.get(j)]--;
                    if (inDegree[edges.get(j)] == 0) {
                        q.offer(edges.get(j));
                    }
                }
            }
        }

        return count == numCourses;
    }
}
