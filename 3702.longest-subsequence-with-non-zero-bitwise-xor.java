class Solution {
    public int longestSubsequence(int[] nums) {
        int N = nums.length;
        int s = 0;
        boolean flag = true;
        
        for (int n : nums) {
            s ^= n;
            if (n != 0) {
                flag = false;
            }
        }
        
        if (flag) {
            return 0;
        }
        if (s == 0) {
            return N - 1;
        }
        
        return N;
    }
}