public class Solution {
    void help(long[] a, boolean inverse) {
        int n = a.length;
        for (int h = 1; h < n; h *= 2) {
            for (int i = 0; i < n; i += h * 2) {
                for (int j = 0; j < h; j++) {
                    long x = a[i + j];
                    long y = a[i + j + h];
                    a[i + j] = x + y;
                    a[i + j + h] = x - y;
                }
            }
        }
        if (inverse) {
            for (int i = 0; i < n; i++) {
                a[i] = Math.round((double) a[i] / n);
            }
        }
    }

    public int uniqueXorTriplets(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        if (set.isEmpty()) return 0;

        int maxVal = Collections.max(set);
        int m = Integer.toBinaryString(maxVal).length();
        int L = 1 << m;
        long[] f = new long[L];
        for (int num : set) {
            f[num] = 1;
        }

        help(f, false);
        for (int i = 0; i < L; i++) {
            f[i] = f[i] * f[i] * f[i];
        }
        help(f, true);

        int count = 0;
        for (long x : f) {
            if (x > 0) count++;
        }
        return count;
    }
}