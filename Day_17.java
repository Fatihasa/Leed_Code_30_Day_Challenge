
/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
Example 1:
Input:
11110
11010
11000
00000
Output: 1
Example 2:
Input:
11000
11000
00100
00011
Output: 3
*/

//Complexity of this solution is row x column 
class Solution {
    public int numIslands(char[][] grid) {
     
        if (grid.length == 0)
            return 0;
        
        int count = 0;
        char[][] bigGrid = new char[grid.length+2][grid[0].length+2];
        
        // To avoid index out of bound exception it is used a bigger array
        // Index out of bound errors can be solved without an extra array but space complexity was ignored for the problem
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                bigGrid[i+1][j+1] = grid[i][j];    
            }   
        }
        
        //calls the recursive algorithm to find the islands in a loop for each xy point in 2d grid
        for(int i = 1; i < bigGrid.length-1; i++) {
            for(int j = 1; j < bigGrid[0].length-1; j++) {
                if(bigGrid[i][j] == '1') {
                    count++; 
                    turnToTwo(bigGrid, i, j);
                }
            }
        }
        return count;
    }    
    
    
    //recursive algorithm to check each adjacent part of the island
    public void turnToTwo(char[][] bigGrid, int i, int j) {
        bigGrid[i][j] = '2';
        
        if(bigGrid[i-1][j] == '1') 
            turnToTwo(bigGrid, i-1, j);
        if(bigGrid[i+1][j] == '1') 
            turnToTwo(bigGrid, i+1, j);
        if(bigGrid[i][j-1] == '1') 
            turnToTwo(bigGrid, i, j-1);
        if(bigGrid[i][j+1] == '1') 
            turnToTwo(bigGrid, i, j+1);      
    }
}
