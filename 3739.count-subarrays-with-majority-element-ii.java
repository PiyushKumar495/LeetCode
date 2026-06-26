class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int size = nums.length, pref = size;

        int[] freq = new int[2 * size + 1];
        freq[size] = 1;

        long less = 0, ans = 0;

        for (int num : nums) {
            if (num == target)
                less += freq[pref++];
            else
                less -= freq[--pref];

            ++freq[pref];
            ans += less;
        }

        return ans;
    }
}