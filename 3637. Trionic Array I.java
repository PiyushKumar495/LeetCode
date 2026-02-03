class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if (n < 4) return false;

        int i = 0;

        boolean inc1 = false;
        while (i + 1 < n && nums[i] < nums[i + 1]) {
            inc1 = true;
            i++;
        }

        boolean dec = false;
        while (i + 1 < n && nums[i] > nums[i + 1]) {
            dec = true;
            i++;
        }
        boolean inc2 = false;
        while (i + 1 < n && nums[i] < nums[i + 1]) {
            inc2 = true;
            i++;
        }

        return inc1 && dec && inc2 && i == n - 1;
    }
}