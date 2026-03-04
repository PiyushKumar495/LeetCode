class Solution {

    public int numSpecial(int[][] mat) {
        int count = 0;
        int row1s[] = new int[mat.length];
        int col1s[] = new int[mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] == 1){
                    row1s[i]++;
                    col1s[j]++;
                }
            }
        }
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                 if(mat[i][j] == 1){
                    if(row1s[i] == 1 && col1s[j] == 1) count++;
                }
            }
        }
        return count;
    }
}