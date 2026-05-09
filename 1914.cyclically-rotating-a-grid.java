// TC : O(mxnxtempK) where tempK = k%(length of shell)
// SC : O(1) 
// c1 , c2 ,c3 , c4 represent corners of rectangle in consideration
// c1i , c1j -> (i,j) for corner 1 and so on  

class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int shells = grid.length<grid[0].length?grid.length/2:grid[0].length/2; // shells = layers
        int c1i = 0 , c1j = 0;
        int c2i = 0 , c2j = grid[0].length-1;
        int c3i = grid.length-1 , c3j = grid[0].length-1;
        int c4i = grid.length-1 , c4j = 0;
           while(shells>0){ // rotate each shell
               int len = (c2j-c1j+1)+(c3i-c2i+1)+(c3j-c4j+1)+(c4i-c1i+1)-4; // length of shell 
               int tempk = k%len;
               while(tempk>0){ // rotate shell
               rotate(grid,c1i,c1j,c2i,c2j,c3i,c3j,c4i,c4j);
               tempk--;
               }
               // update corners for next shell 
               c1i++;
               c1j++;
               c2i++;
               c2j--;
               c3i--;
               c3j--;
               c4i--;
               c4j++;
               shells--;
           }
        return grid;
    }
    private void rotate(int grid[][], int c1i , int c1j , int c2i , int c2j , int c3i , int c3j , int c4i , int c4j){ // to rotate shell
        int oldVal = grid[c1i][c1j];
        for(int i = c1i , j = c1j;j<c2j;j++){
            grid[i][j] = grid[i][j+1];
        }
        for(int i = c1i,j=c2j;i<c3i;i++){
            grid[i][j] = grid[i+1][j];
        }
        for(int j = c3j , i = c3i ;j>c4j;j--){
            grid[i][j] = grid[i][j-1];
        }
        for(int i = c4i , j = c4j ;i>c1i+1;i--){
            grid[i][j] = grid[i-1][j];
        }
        grid[c1i+1][c1j] = oldVal;
    }
}