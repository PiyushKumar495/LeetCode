import java.util.Arrays;

class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        return Math.min(
            solve(landStartTime, landDuration, waterStartTime, waterDuration),
            solve(waterStartTime, waterDuration, landStartTime, landDuration)
        );
    }
    
    private int solve(int[] start1, int[] dur1, int[] start2, int[] dur2) {
        int n = start1.length;
        int m = start2.length;
        
        int[][] v = new int[m][2];
        for (int i = 0; i < m; i++) {
            v[i][0] = start2[i];
            v[i][1] = dur2[i];
        }
        Arrays.sort(v, (a, b) -> Integer.compare(a[0], b[0]));
        
        int[] lmin = new int[m];
        int[] rmin = new int[m];
        
        lmin[0] = v[0][1];
        for (int i = 1; i < m; i++) {
            lmin[i] = Math.min(lmin[i-1], v[i][1]);
        }
        
        rmin[m-1] = v[m-1][0] + v[m-1][1];
        for (int i = m - 2; i >= 0; i--) {
            rmin[i] = Math.min(rmin[i+1], v[i][0] + v[i][1]);
        }
        
        int minFinish = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            int finishTime1 = start1[i] + dur1[i];
            
            int low = 0, high = m;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (v[mid][0] > finishTime1) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            int id = low;
            
            if (id < m) {
                minFinish = Math.min(minFinish, rmin[id]);
            }
            if (id > 0) {
                minFinish = Math.min(minFinish, finishTime1 + lmin[id-1]);
            }
        }
        
        return minFinish;
    }
}