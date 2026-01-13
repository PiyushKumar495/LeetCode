class Solution {
    public double separateSquares(int[][] squares) {
        double low = 1e9, high = -1e9;

        for (int[] s : squares) {
            low = Math.min(low, s[1]);
            high = Math.max(high, s[1] + s[2]);
        }

        for (int i = 0; i < 60; i++) {
            double mid = (low + high) / 2;
            if (diff(squares, mid) > 0) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return (low + high) / 2;
    }

    private double diff(int[][] squares, double h) {
        double below = 0, total = 0;

        for (int[] s : squares) {
            double y = s[1], l = s[2];
            double area = l * l;
            total += area;

            if (h > y) {
                below += Math.min(l, h - y) * l;
            }
        }

        return (total - below) - below;
    }
}