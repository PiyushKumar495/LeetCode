class Solution {
    public int smallestNumber(int n, int t) {

        //no upperbound specified in for loop as we dont know it
        for(int i=n; ;i++)
        {
            int num = i;
            int prod = 1;
            while(num > 0)
            {
                int rem = num %10;
                prod = prod * rem;
                num = num /10;
            } 
            if (prod % t == 0)
            {
                return i;
            }
        }
    }
}