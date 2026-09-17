class Solution {
    public boolean isValidSudoku(char[][] board) {
        ArrayList<Set<Character>> rows = new ArrayList<>();
        ArrayList<Set<Character>> cols = new ArrayList<>();
        ArrayList<Set<Character>> boxes = new ArrayList<>();
        
        for (int i = 0; i < 9; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            boxes.add(new HashSet<>());
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char val = board[i][j];
                if (val == '.') {
                    continue;
                }
                int bNum = getBoxNum(i, j);
                if (rows.get(i).contains(val) || cols.get(j).contains(val) || boxes.get(bNum).contains(val)) {
                    return false;
                }

                rows.get(i).add(val);
                cols.get(j).add(val);
                boxes.get(bNum).add(val);
            }
        }

        return true;
    }

    public int getBoxNum(int i , int j) {
        int iVal = Math.floorDiv(i, 3);
        int jVal = Math.floorDiv(j, 3);

        if (iVal == 0) {
            if (jVal == 0) {
                return 0;
            } else if (jVal == 1) {
                return 1;
            }
            return 2;
        } else if (iVal == 1) {
            if (jVal == 0) {
                return 3;
            } else if (jVal == 1) {
                return 4;
            }
            return 5;
        } else {
            if (jVal == 0) {
                return 6;
            } else if (jVal == 1) {
                return 7;
            }
            return 8;
        }
    }
}
