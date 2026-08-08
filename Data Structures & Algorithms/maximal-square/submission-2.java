class Solution {
    public int maximalSquare(char[][] matrix) {
      // consider i as the top left corner of my square
      // check neighbours. break if encounter 0. add area if all are 1  

        int area = 0;
        int[][] memo = new int[matrix.length][matrix[0].length];
        for(int[] row: memo) {
            Arrays.fill(row, -1);
        }

        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[i].length;j++) {
                char corner = matrix[i][j];
                if(corner != '1') continue;
                int a = side(matrix, i, j, memo);
                area = Math.max(area, a*a);
            }
        }

        return area;
    }

    private int side(char[][] matrix, int row, int column, int[][] memo) {
        if (matrix[row][column] != '1') {
            return 0;
        }

        if (row == matrix.length - 1 ||
            column == matrix[0].length - 1) {
            return 1;
        }

        if(memo[row][column] != -1) return memo[row][column];

        int right = side(matrix, row, column + 1, memo);
        int down = side(matrix, row + 1, column, memo);
        int diagonal = side(matrix, row+1, column+1, memo);
        memo[row][column] = 1+ Math.min(right, Math.min(down, diagonal));
        return memo[row][column];
    }
}