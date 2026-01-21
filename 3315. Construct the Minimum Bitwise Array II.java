class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans = new int[nums.size()];
        Arrays.fill(ans, -1);

        for(int i=0; i<ans.length; i++){
            int res = -1, d = 1, x = nums.get(i);
            while((x & d) != 0){
                res = x-d;
                d <<=1;
            }
            ans[i] = res;

        }
        return ans;
        
    }
}