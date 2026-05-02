class Solution 
{
    public int rotatedDigits(int n) 
    {
        int ans=0;
        for(int i=2;i<=n;i++)//skipped 1 because that will always be not valid
        {
            if(rotated(i))
            ans++;
        }
        return ans;
    }
    public boolean rotated(int n)//to rotate each number and check against original
    {
        int rot=0;
        String num=""+n;
        int i=0;
        int len=num.length();
        while(i<len)
        {
            int res=mapping(Integer.parseInt(""+num.charAt(i)));//find rotated of each digit from the starting
            if(res==-1)
            return false;
            rot=rot*10+res;//constructing the rotated number
            i++;
        }
        if(rot==n)
        return false;
        return true;
    }
    public int mapping(int dig)
    {
        if(dig==9)
        return 6;
        if(dig==1 || dig==0 || dig==8)
        return (dig);
        if(dig==6)
        return 9;
        if(dig==2)
        return 5;
        if(dig==5)
        return 2;
        return -1;//not mapping to any number(3,4,7)

    }
}