class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    //explore all connected nodes
                    dfs(grid, i, j);
                }
            }
        }

        return islands;
    }

    public void dfs(char[][] grid, int i, int j) {
        //check edge conditions
        Deque<int[]> s = new ArrayDeque<>();

        s.push(new int[]{i, j});

        while (!s.isEmpty()) {
            int[] curr = s.pop();

            if (curr[0] < 0 || curr[1] < 0 || curr[0] >= grid.length || curr[1] >= grid[i].length || grid[curr[0]][curr[1]] == '0') {
                continue;
            }
            grid[curr[0]][curr[1]] = '0';

            s.push(new int[]{curr[0] + 1, curr[1]});
            s.push(new int[]{curr[0] - 1, curr[1]});
            s.push(new int[]{curr[0], curr[1] + 1});
            s.push(new int[]{curr[0], curr[1] - 1});
        }    
    }
}
