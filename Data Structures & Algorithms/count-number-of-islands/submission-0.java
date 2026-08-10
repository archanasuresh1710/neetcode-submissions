class Solution {
    public int numIslands(char[][] grid) {
       /*
       approach 1: choosing one cell, if it's 1 move horizontal and vertical until we hit a 0 -> 1 island found
            - choosing next cell -> was visited previously

        if a cell is 1 -> count as an island and mark it's neighbours (which are 1) as 0
        traverse through the path of neighbours until we hit a 0

        time: O(mxn) for traversing across the array and visiting each cell once
        space: O(mxn) worst case entire array is 1 -> mxn recursions
       */
        int m = grid.length;
        int n = grid[0].length;
        int island = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == '1') {
                    island++;
                    markNeighbours(grid, i, j);
                }
            }
        }

        return island;
    }

    private void markNeighbours(char[][] grid, int row, int column) {

        if(row < 0 || column < 0 
            || row == grid.length 
            || column == grid[0].length 
            || grid[row][column] == '0'
        ) return;

        grid[row][column] = '0';

        markNeighbours(grid, row+1, column);
        markNeighbours(grid, row-1, column);
        markNeighbours(grid, row, column+1);
        markNeighbours(grid, row, column-1);
    }
}
