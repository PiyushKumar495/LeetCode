class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            int min = 999999999;
            for (int j = i; j < n; j++)
                min = Math.min(nums[j], min);
            System.out.println(max + "  " + min);
            if (max - min <= k)
                return i;
        }
        return -1;
    }
}