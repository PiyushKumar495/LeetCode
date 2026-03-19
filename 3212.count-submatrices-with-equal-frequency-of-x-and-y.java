class Solution {
    public int numberOfSubmatrices(char[][] grid) {
       int[] countX = new int[grid[0].length];
       int[] countY = new int[grid[0].length];
       int num=0;
       for(int i=0;i<grid.length;i++){

        int x=0;
        int y=0;
        for(int j=0;j<grid[0].length; j++){

             if(grid[i][j] == 'X')
                x++;
             if(grid[i][j]== 'Y')
                y++;
            countX[j] +=x;
            countY[j] +=y;
            if(countX[j]>=1 && (countX[j]==countY[j])){
                num++;
            }
        }
        }

    return num;

       
    }
}