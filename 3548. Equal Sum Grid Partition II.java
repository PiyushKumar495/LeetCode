class Solution {
    int row, col;
    public boolean canPartitionGrid(int[][] grid) {
        row = grid.length;
        col = grid[0].length;

        HashMap<Long, int[]> map = new HashMap<>();

        long total = 0;
        long[] pre = new long[col];

        for(int j = 0; j < col; j++) {
            long temp = 0;
            for (int i = 0; i < row; i++) {

                long val = grid[i][j];

                map.putIfAbsent(val, new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE});
                map.get(val)[0] = Math.min(map.get(val)[0], j);
                map.get(val)[1] = Math.max(map.get(val)[1], j);

                temp += val;
            }
            pre[j] = temp;
            total += temp;
        }

        if(col > 1 && colChecking(grid, pre, map, total)) return true;

        map = new HashMap<>();
        pre = new long[row];

        for(int i = 0; i < row; i++) {
            long temp = 0;
            for(int j = 0; j < col; j++) {

                long val = grid[i][j];

                map.putIfAbsent(val, new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE});
                map.get(val)[0] = Math.min(map.get(val)[0], i);
                map.get(val)[1] = Math.max(map.get(val)[1], i);

                temp += val;
            }
            pre[i] = temp;
        }

        if(row <= 1) return false;
        return rowChecking(grid, pre, map, total);
    }

    public boolean rowChecking(int[][] grid, long[] pre, HashMap<Long, int[]> map, long total) {

        for(int i = 0; i < row - 1; i++) {
            if(i > 0) pre[i] += pre[i - 1];

            long left = pre[i];
            long right = total - left;

            if(left == right) return true;

            long gp = Math.abs(left - right);
            if(map.containsKey(gp)) {
                int min = map.get(gp)[0];
                int max = map.get(gp)[1];

                if(right > left && max > i) {
                    int dst = row - (i + 1);

                    if(dst != 1) {
                        if(col > 1) return true;
                        else if(grid[i + 1][0] == gp || grid[row - 1][0] == gp) return true;
                    } 
                    else if (grid[row - 1][0] == gp || grid[row - 1][col - 1] == gp) return true;

                }
                else if (left > right && min <= i) {

                    if(i + 1 != 1) {
                        if(col > 1) return true;
                        else if(grid[0][0] == gp || grid[i][0] == gp) return true;
                    } 
                    else if (grid[0][0] == gp || grid[0][col - 1] == gp) return true;
                }
            }
        }

        return false;
    }

    public boolean colChecking(int[][] grid, long[] pre, HashMap<Long, int[]> map, long total) {

        for(int j = 0; j < col - 1; j++) {
            if(j > 0) pre[j] += pre[j - 1];

            long left = pre[j];
            long right = total - left;

            if(left == right) return true;

            long gp = Math.abs(left - right);
            if(map.containsKey(gp)) {
                int min = map.get(gp)[0];
                int max = map.get(gp)[1];

                if(right > left && max > j) {
                    int dst = col - (j + 1);

                    if(dst != 1) {
                        if(row > 1) return true;
                        else if (grid[0][j + 1] == gp || grid[0][col - 1] == gp) return true;
                    } 
                    else if(grid[0][col - 1] == gp || grid[row - 1][col - 1] == gp) return true;

                } 
                else if (left > right && min <= j) {

                    if(j + 1 != 1) {
                        if(row > 1) return true;
                        else if(grid[0][0] == gp || grid[0][j] == gp) return true;
                    } 
                    else if(grid[0][0] == gp || grid[row - 1][0] == gp) return true;
                }
            }
        }

        return false;
    }
}