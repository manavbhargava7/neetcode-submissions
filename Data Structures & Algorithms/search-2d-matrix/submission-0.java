class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        /*
        Notes: 2d Integer Array: Matrix, and a target
        each row is sorted in ascending order
        
        return true if in row, false otherwise

        Approach:
        1. Brute force, go though each value, see if target exists return true -> o(n^2)
        2. Binary Search, with condition, use function to find middle 
        */

        int l = 0; 
        int r = (matrix.length * matrix[0].length) - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            int val = findMatrixVal(m, matrix);

            if (val < target) {
                l = m + 1;
            } else if (target < val){
                r = m - 1;
            } else {
                return true;
            }
        }

        return false;    
    }

    private int findMatrixVal(int m, int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        return matrix[Math.floorDiv(m, c)][m % c];
    }
}
