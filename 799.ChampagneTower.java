class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] prevsrow = new double[]{poured};
        for(int i = 1; i <= query_row; i++){
            double[] currentrow = new double[i + 1];
            for(int j = 0; j < i; j++){
                double extra = prevsrow[j] - 1;
                if(extra > 0){
                    currentrow[j] += 0.5 * extra;
                    currentrow[j + 1] += 0.5 * extra;
                }
            }
            prevsrow = currentrow;
        }
        return Math.min(1.0, prevsrow[query_glass]);
    }
}