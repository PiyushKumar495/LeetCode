
class Solution {
    public int zigZagArrays(int n, int l, int r) {
		int mod = 1_000_000_007;
		long[] dp = new long[r + 2];
		for(int i = l; i <= r; i++) {
			dp[i] = dp[i - 1] + 1;
		}
		for(int i = 1; i < n; i++) {
			long[] temp = new long[r + 2];
			for(int j = l; j <= r; j++) {
				temp[j] += temp[j - 1] + dp[r - (j + 1 - l)];
				temp[j] %= mod;
			}
			dp = temp;
		}
		return (int) (2 * dp[r] % mod);
    }
}