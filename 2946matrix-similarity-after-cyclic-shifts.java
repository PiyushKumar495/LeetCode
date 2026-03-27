class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int n=mat.length;
        int m=mat[0].length;
        k=k%m;
        int ar[][]=new int[n][m];
        for(int i=0;i<n;i++){
            int t=0;
            for(int j=k;j<m;j++){
                ar[i][t++]=mat[i][j];
                if(ar[i][t-1]!=mat[i][t-1]){
                    return false;
                }
            }
            for(int j=0;j<k;j++){
                ar[i][t++]=mat[i][j];
                if(ar[i][t-1]!=mat[i][t-1]){
                    return false;
                }
            }
        }
        return true;
    }
}