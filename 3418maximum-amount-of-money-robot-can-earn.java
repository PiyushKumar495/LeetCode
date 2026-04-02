class Solution
{
    public int maximumAmount(int[][] coins)
    {
        int n = coins[0].length;
        int [][] m = new int[n+1][3];

        for(int i=0; i<=n; i++)
            Arrays.fill(m[i], Integer.MIN_VALUE/2);

        for (int i=0; i<3; i++)
            m[1][i] = 0;

        for (int [] r : coins)
            for (int j = 1; j <= n; j++)
            {
                m[j][2] = max(m[j-1][2]+r[j-1], m[j][2]+r[j-1], m[j-1][1], m[j][1]);
                m[j][1] = max(m[j-1][1]+r[j-1], m[j][1]+r[j-1], m[j-1][0], m[j][0]);
                m[j][0] = max(m[j-1][0], m[j][0])+r[j-1];
            }

        return m[n][2];
    }

    int max(int... a)
    {
        int r = a[0];

        for(int i=1, l=a.length; i<l; i++)
            r = Math.max(r,a[i]);

        return r;
    }
}