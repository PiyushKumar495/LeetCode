class Solution {
    Integer[][] cache;
    
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        
        cache = new Integer[n + 1][n + 1];
        
        //cumlative sum of stone values
        int[] prefixSum = new int[n + 1];
        for(int i = 0; i < n; i++){
            prefixSum[i + 1] = prefixSum[i] + stoneValue[i];
        }

        return getAliceStore(prefixSum, 1, n);
    }
    
    private int getAliceStore(int[] prefixSum , int l, int r){
        if(l == r) return 0;
        
        //reterive from cache 
        if(cache[l][r] != null) return cache[l][r];
        
        int maxScore = Integer.MIN_VALUE;
        for(int i = l; i <= r - 1; i++){
            int left  = prefixSum[i] - prefixSum[l - 1];
            int right = prefixSum[r] - prefixSum[i];
            
            if(left > right){
                //As right is smaller than left, Bob will select smaller sub row
                maxScore = Math.max(maxScore, right + getAliceStore(prefixSum, i + 1, r));
                
            }else if(left < right){
                //As left is smaller than right, Bob will select smaller sub row
                maxScore = Math.max(maxScore, left + getAliceStore(prefixSum, l, i));
                
            }else if(left == right){
                //lets Alice decide which row will be thrown away. 
                maxScore = Math.max(maxScore, left + getAliceStore(prefixSum, l, i));
                maxScore = Math.max(maxScore, right + getAliceStore(prefixSum, i + 1, r));
            }
        }
        
        //save in cache  
        return cache[l][r]  = maxScore;
    }
}