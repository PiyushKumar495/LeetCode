class Solution {
    public int minimumPushes(String word) {
        int count=1,ind=1,sum=0;
        for(char c:word.toCharArray())
        {
            if(ind>8)
            {
                ind=2;
                count++;
            }
            else
            {
                ind++;
            }
            sum=sum+(count*1);
        }
        return sum;
    }
}