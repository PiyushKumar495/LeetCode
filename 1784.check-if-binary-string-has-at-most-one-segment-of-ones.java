class Solution {
    public boolean checkOnesSegment(String s) {
        boolean findZero = false;
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch  == '0'){
             findZero = true;
            }
            if(ch == '1' && findZero ){
                return false;
            }

        }
        return true;
        
    }
}