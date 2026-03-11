class Solution 
{
    public int bitwiseComplement(int n) 
    {
        String res=Integer.toBinaryString(n);
        String res1="";
        for(char c: res.toCharArray())
        {
            if(c=='1')
            {
                res1=res1+'0';
            }
            else
            {
                res1=res1+'1';
            }
        }
        int ans=Integer.parseInt(res1,2);
        return ans;

    }
}