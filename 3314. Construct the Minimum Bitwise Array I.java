class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {

        int n = nums.size();
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {

            int val = nums.get(i);
            int count = 0;

            while ((val & 1) == 1) {
                val >>= 1;
                count++;
            }

            if (count == 0) {
                res[i] = -1;
            } else {
                res[i] = nums.get(i) - (int) Math.pow(2, count - 1);
            }
        }
        return res;
    }
}