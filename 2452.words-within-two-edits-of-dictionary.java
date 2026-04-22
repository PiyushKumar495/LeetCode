class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {

        var result = new ArrayList<String>();

        for(String query : queries) {
            boolean match = false;

            for(String dict : dictionary) {
                
                // compare every words
                if(check(query, dict) == true) {
                    match = true;
                    break;
                }

            }

            if(match == true) {
                result.add(query);
            }

        }

        return result;
        
    }


    private boolean check(String a, String b) {

        if(a.length() != b.length())
            return false;


        var count = 0;

        for(int i=0;i<a.length();i++) {
            if(a.charAt(i) != b.charAt(i))
                count++;
            
            if(count > 2)
                return false;
        }

        return true;

    }

}