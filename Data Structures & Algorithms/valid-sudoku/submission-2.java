class Solution {

    private final Map<Character, Integer> map = new HashMap<>();

    public boolean isValidSudoku(char[][] board) {
        
        for(int i=0;i<board.length;i++) {
            map.clear();
            
            // check row 
            for(int c=0;c<board.length;c++) {
                insert(board,i,c);
            }
            if(!isValid()) return false;

            map.clear();

            // check column 
            for(int r=0;r<board.length;r++) {
                insert(board,r,i);
            }
            if(!isValid()) return false;
        }

        map.clear();
        // System.out.println("Cleared MAP: " + map);

        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {

                map.clear();

                for (int r = row; r < row + 3; r++) {
                    for (int c = col; c < col + 3; c++) {
                            insert(board, r, c);
                        }
                }

                if (!isValid()) return false;
            }
        }

        return true;
    }

    private void insert(char[][] board, int row, int col) {
        char digit = board[row][col];
        map.put(digit, map.getOrDefault(digit, 0) + 1);
    }

    private boolean isValid() {
        System.out.println("Map: " + map);
        long invalid = map.entrySet().stream()
                            .filter(entry -> (entry.getKey() != '.' && entry.getValue() > 1))
                            .count();
        if(invalid != 0) return false;
        return true;
    }
}
