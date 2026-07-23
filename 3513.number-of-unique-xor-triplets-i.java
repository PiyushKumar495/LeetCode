class Solution {
    public int uniqueXorTriplets(int[] nums) 
    {
        int n = nums.length;
        return n < 3 ? n : Integer.highestOneBit(n) << 1; 
    }
}