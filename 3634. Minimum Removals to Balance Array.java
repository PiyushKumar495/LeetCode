class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int i=0;
        int n = nums.length;
        int j=0;
        int ans =0;
        while(j<n){
            while((long)nums[i]*k < nums[j]) i++;
            ans = Math.max(ans, j-i+1);
            j++;
        }
        return n-ans;
    }
}