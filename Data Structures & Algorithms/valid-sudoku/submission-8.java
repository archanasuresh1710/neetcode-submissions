class Solution {

    private final Map<Character, Integer> map = new HashMap<>();

    public boolean isValidSudoku(char[][] board) {
        
        for(int i=0;i<board.length;i++) {
            map.clear();
            
            // check row 
            for(int c=0;c<board.length;c++) {
                if(!insert(board,i,c)) return false;
            }
            // if(!isValid()) return false;

            map.clear();

            // check column 
            for(int r=0;r<board.length;r++) {
                if(!insert(board,r,i)) return false;
            }
            // if(!isValid()) return false;
        }

        map.clear();

        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {

                map.clear();

                for (int r = row; r < row + 3; r++) {
                    for (int c = col; c < col + 3; c++) {
                            if(!insert(board, r, c)) return false;
                        }
                }

                // if (!isValid()) return false;
            }
        }

        return true;
    }

    private boolean insert(char[][] board, int row, int col) {
        char digit = board[row][col];
        if(digit == '.') return true;

        int count = map.getOrDefault(digit, 0) + 1;

        if(count > 1) return false;

        map.put(digit, count);
        return true;
    }

    private boolean isValid() {
        for(Map.Entry<Character,Integer> entry : map.entrySet()) {
            if(entry.getValue() > 1) return false;
        }
        return true;
    }
}
