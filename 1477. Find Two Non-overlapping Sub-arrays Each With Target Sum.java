class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int INF = 1000000;
        int[] minLen = new int[n];
        java.util.Arrays.fill(minLen, INF);
        int ans = INF;
        int left = 0, currentSum = 0;

        for (int right = 0; right < n; ++right) {
            currentSum += arr[right];

            while (currentSum > target) {
                currentSum -= arr[left++];
            }

            if (right > 0) {
                minLen[right] = minLen[right - 1];
            }

            if (currentSum == target) {
                int currLen = right - left + 1;
                if (left > 0 && minLen[left - 1] < INF) {
                    ans = Math.min(ans, minLen[left - 1] + currLen);
                }
                minLen[right] = Math.min(minLen[right], currLen);
            }
        }

        return ans >= INF ? -1 : ans;
    }
}