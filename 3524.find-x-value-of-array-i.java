class Solution {
    public long[] resultArray(int[] nums, int k) {

        long[] result = new long[k];

        // dp[r] =
        // number of subarrays ending at the previous index
        // whose product % k == r
        long[] dp = new long[k];

        for (int num : nums) {

            // We only care about num % k
            int rem = num % k;

            // Build states for subarrays
            // ending at the current index
            long[] next = new long[k];

            // Start a new subarray with only this number
            next[rem]++;

            // Extend every previous subarray
            for (int r = 0; r < k; r++) {

                int newRem = (r * rem) % k;

                next[newRem] += dp[r];
            }

            // Current state becomes previous state
            // for the next iteration
            dp = next;

            // Every state here represents a different
            // subarray ending at the current index.
            for (int r = 0; r < k; r++) {
                result[r] += dp[r];
            }
        }

        return result;
    }
}