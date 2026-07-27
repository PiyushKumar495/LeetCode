class Solution {
    public int maxProduct(int[] nums) {
        int Max=0;
        int secondMax=0;
        for(int num :nums){
            if(num>=Max){
                secondMax=Max;
                Max=num;
            }else if(num>secondMax){
                secondMax=num;
            }

        }return (Max-1)*(secondMax-1);
        
    }
}