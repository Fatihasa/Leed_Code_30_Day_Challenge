/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
Note: You can only move either down or right at any point in time.
Example:
Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
*/


//This approach adds up the values and updates the matrix for memorization 
class Solution {
    public int minPathSum(int[][] grid) {
    
        //loop for each rows
        for(int i = 0, y = 0 ; i< grid.length ; i++) {
            
            //If statement for the top row
            if(i==0) {
                for(int j = 0 ; j< grid[0].length-1 ; j++){
                    grid[i][j+1] = grid[i][j+1] + grid[i][j];
                }
            }else if(i != 0) {
                
                //loop for the inner points compares the edges and updates
                for(int j=1; j< grid[0].length ; j++ ){
                    
                    if(grid[i][j-1]<grid[i-1][j] ){
                         grid[i][j] = grid[i][j-1] + grid[i][j];
                        
                    }else{
                         grid[i][j] =  grid[i-1][j] + grid[i][j];
                    }
                    
                }
                
            }
            //If statement for the leftmost column
            if( i != grid.length -1){
                grid[i+1][y] = grid[i][y] + grid[i+1][y];

            }
                    
        }
        
        //Finally returns the point on the bottom rightmost.
        return grid[grid.length-1][grid[0].length-1];
      
    }
}
