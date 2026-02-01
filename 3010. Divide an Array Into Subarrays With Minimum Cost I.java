class Solution {
    public int minimumCost(int[] nums) {
        int a=nums[0];
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=1;i<nums.length;i++)
        {
            arr.add(nums[i]);
        }

        Collections.sort(arr);
        

        return a + arr.get(0)+arr.get(1);
    }
}