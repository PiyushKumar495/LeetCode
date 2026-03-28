class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        char [] arr = new char [n];
        arr[0] = 'a';
        
        char test;
        boolean found;
        
        for (int i = 1; i < n; ++i) {
            test = 'a';
            found = false;
            
            for (int j = 0; j < i; ++j){
                test = (char)Math.max(test, arr[j]);
                
                if (lcp[i][j] != 0){
                    found = true;
                    arr[i] = arr[j];  
                    break;
                }    
            }
            
            if (found)
                continue;
            
            ++test;
            arr[i] = test;
            if (test > 'z')
                return "";
        }
        int [][] dp = new int [n + 1][n + 1];
        
        int val;
        
        for (int i = n - 1; i >= 0; --i){
            for (int j = n - 1; j >= 0; --j) {
                if (arr[i] != arr[j])
                    val = 0;
                else
                    val = 1 + dp[i + 1][j + 1];
                
                dp[i][j] = val;
            }
        }
        for (int i = n - 1; i >= 0; --i){
            for (int j = n - 1; j >= 0; --j) {
                if (dp[i][j] != lcp[i][j])
                    return "";
            }
        }
        
        return String.valueOf(arr);
    }
}