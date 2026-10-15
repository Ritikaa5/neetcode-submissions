class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];
        
        // Har row, col, box ke liye empty HashSet banao
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];
                
                if (val == '.') continue; // empty cell skip karo
                
                int boxIndex = (r / 3) * 3 + (c / 3);
                
                // Agar yeh digit already row, col, ya box me dekha hai, toh invalid hai
                if (rows[r].contains(val) || cols[c].contains(val) || boxes[boxIndex].contains(val)) {
                    return false;
                }
                
                // Warna, teeno jagah add kar do
                rows[r].add(val);
                cols[c].add(val);
                boxes[boxIndex].add(val);
            }
        }
        
        return true;
    }
}
