class Solution {
    public boolean isGood(int[] nums) {
        int n=nums.length;
        int count[]=new int [n+1];
        for(int i=0;i<n;i++){
            if(nums[i]<1 || nums[i]>n-1){
                return false;
            }
            count[nums[i]]++;
        }
        if(count[n-1]!=2 ){
            
            return false;
        }
        for(int i=1;i<=n-2;i++){
            if(count[i]!=1){
                return false;
            }
        
        }
        return true;
    }
}