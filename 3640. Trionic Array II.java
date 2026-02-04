class Solution {
    public long maxSumTrionic(int[] nums) {
        long ans=(long)(-1e15);
        for(int i=2;i<nums.length-1;i++){
            if(nums[i]<nums[i-1]&&nums[i]<nums[i+1]){
                // inc moreinc moremoreinc dec moredec  moremoredec   inc  moreinc
                //                                     {This element}
                // while(nums[i])
                int l=i-1,r=i+1;
                long rsum=nums[r],maxrsum=nums[r],lsum=0;
                r++;
                while(r<nums.length&&nums[r]>nums[r-1]){
                    rsum+=nums[r];
                    maxrsum=Math.max(maxrsum,rsum);
                    r++;
                }
                r--;
                // right barabar h mid se to cannot expand right inc part babe
                if(r<=i) continue;
                // figure out left part
                while(nums[l+1]<nums[l]){
                    lsum+=nums[l];
                    l--;
                }
                if(l<0) continue;
                long csum=nums[l],maxcsum=nums[l];
                l--;
                while(l>=0&&nums[l]<nums[l+1]){
                    csum+=nums[l];
                    maxcsum=Math.max(maxcsum,csum);
                    l--;
                }
                ans=Math.max(ans,maxcsum+lsum+nums[i]+maxrsum);
                // System.out.println(i+" "+lsum+" "+l);
                i=r;
            }
        }
        return ans;
    }
}