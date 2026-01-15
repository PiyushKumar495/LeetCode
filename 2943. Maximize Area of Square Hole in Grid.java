class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        if (hBars.length == 0 || vBars.length == 0) return 1;
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int maxH = 1;
        int countH = 1;
        for (int i = 1; i < hBars.length; ++i) {
            int prev = hBars[i - 1];
            int cur = hBars[i];
            if (prev + 1 == cur) {
                ++countH;
                maxH = Math.max(maxH, countH);
            } else countH = 1;
            
        }
        int maxV = 1;
        int countV = 1;
        for (int i = 1; i < vBars.length; ++i) {
            int prev = vBars[i - 1];
            int cur = vBars[i];
            if (prev + 1 == cur) {
                ++countV;
                maxV = Math.max(maxV, countV);
            } else countV = 1;
        }
        int min = Math.min(maxH, maxV);
        return (min + 1) * (min + 1);
    }
}