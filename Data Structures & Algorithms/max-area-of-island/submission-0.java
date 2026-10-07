class Solution {
    int[][] visited;

    public int maxAreaOfIsland(int[][] grid) {
        //dfs 
        //identify 1, traverse all the others, return size
        //return max size we see
        visited = new int[grid.length][grid[0].length];

        int maxSize = 0;
        
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1 && visited[r][c] != 1) {
                    maxSize = Math.max(maxSize, dfs(grid, r, c));
                }
            }
        }

        return maxSize;
    }

    private int dfs(int[][] grid, int r, int c) {
        if (r >= grid.length || r < 0 || c >= grid[0].length || c < 0) {
            return 0;
        }

        if (visited[r][c] == 1) {
            return 0;
        }

        if (grid[r][c] == 0) {
            return 0;
        } else {
            visited[r][c] = 1;
            return 1 + dfs(grid, r + 1, c) + dfs(grid, r - 1, c) + dfs(grid, r, c + 1) + dfs(grid, r, c - 1);
        }
    }
}
