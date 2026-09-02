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
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) {
            return;
        }

        if (grid[i][j] == '1') {
            //make change
            grid[i][j] = '0';

            //traverse neighbors
            dfs(grid, i + 1, j);
            dfs(grid, i - 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i, j - 1);
        }     
    }
}
