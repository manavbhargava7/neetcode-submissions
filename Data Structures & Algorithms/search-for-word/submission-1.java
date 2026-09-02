class Solution {
    public boolean exist(char[][] board, String word) {
        //graph traversal

        //Aim: find if a word is present in grid
        // - msut be possible to form it with horizontally or vertically neighboring cells. cannot use same cell twice

        /*
        Implementation 
        1: Naive, brute force: find all possible combinations of length of word combinations, see if word is one of them
        2. dfs, explore all possible options for condition


        Questions: do lower and upper case match as well, are we case sensitive?
        are board width and length equal?

        */

        //go through each character
        //see if it matches first letter, if it does, spark dfs from this node

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, new HashSet<>())) {
                        return true;
                    }
                }
            }
        }

        return false;


        //dfs - iterative
        //check node is in bounds
        // check condition
        // if true, explore neighbors
        //how do i maintain visited and prevent repetitive exploration?

    }

    public boolean dfs(char[][] board, String word, int i, int j, Set<String> visited) {
            if (word.length() == 0) {
                return true;
            }

            if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || visited.contains(i + "," + j) || board[i][j] != word.charAt(0)) {
                return false;
            }

            visited.add(i+","+j);
            return dfs(board, word.substring(1), i + 1, j, new HashSet<>(visited)) || dfs(board, word.substring(1), i - 1, j, new HashSet<>(visited)) || dfs(board, word.substring(1), i, j + 1, new HashSet<>(visited)) || dfs(board, word.substring(1), i, j - 1, new HashSet<>(visited));

        }
}
