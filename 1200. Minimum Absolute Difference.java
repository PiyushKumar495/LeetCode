class Solution 
{
    public List<List<Integer>> minimumAbsDifference(int[] nums)
    {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        int min=(int)1e9;
        for(int i=0;i<nums.length-1;i++)
            min=Math.min(min,nums[i+1]-nums[i]);
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i+1]-nums[i] == min)
                ans.add(new ArrayList<>(Arrays.asList(nums[i],nums[i+1])));
        } 
        return ans;
        
        
    }
}