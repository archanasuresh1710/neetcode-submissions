class Solution {
    public boolean exist(char[][] board, String word) {
        // brute force: 
        //  - find the first letter of word in board. If not found -> false
        //  - check neighbours for each letter in the remaining word
        // time: O(n) for finding indexes of first letter
        // for m indexes and string length l, O(mxl) -> O(n^2)

        // Loop through the borad to find the first letter of the word. Start the search from there
        // backtrack with row, column and index. if board[row][column] != word[index] or index out of bound -> false. 
        // if index is the last letter of word => everything is matched. true
        // otherwise -> mark this as visited -> #
        // check for neighbours

        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(word.charAt(0) == board[i][j]) {
                    boolean path = backtrack(board, word, i, j, 0);
                    if(path) return true;
                }
            }
        }

        return false;
    }

    private boolean backtrack(char[][] board, String word, int row, int column, int index) {

        

        if(row < 0 || column < 0 || row >= board.length || column >= board[0].length || board[row][column] != word.charAt(index) || board[row][column] == '#') return false;

        if(index == word.length() - 1) return true;
        
        board[row][column] = '#'; // mark as visited

        boolean down = backtrack(board, word, row+1, column, index+1);
        boolean up = backtrack(board, word, row-1, column, index+1); 
        boolean right = backtrack(board, word, row, column+1, index+1);
        boolean left = backtrack(board, word, row, column-1, index+1);

        if(down || up || right || left) return true;

        board[row][column] = word.charAt(index);
        return false;
    }
}
