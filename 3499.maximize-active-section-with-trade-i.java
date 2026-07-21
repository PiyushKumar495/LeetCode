class Solution {
    public int maxActiveSectionsAfterTrade(String s) { 
        int ones = 0;
        for(int i = 0; i < s.length(); i++) if(s.charAt(i) == '1') ones++;
        
        String S = '1' + s + '1';
        int maxZeros = 0, leftZeros = 0, rightZeros = 0, i = 0;

        while(i < S.length()){
            if(S.charAt(i) == '1'){
                while(i < S.length() && S.charAt(i) == '1') i++;
                if(leftZeros > 0) break;
            }
            else{ 
                leftZeros++;
                i++;
            }
        }

        while(i < S.length()){
            if(S.charAt(i) == '1'){
                maxZeros = Math.max(maxZeros, leftZeros + rightZeros);
                leftZeros = rightZeros;
                rightZeros = 0;
                while(i < S.length() && S.charAt(i) == '1') i++;
            }
            else{
                rightZeros++;
                i++;
            }
        }

        return ones + maxZeros;
    }
}