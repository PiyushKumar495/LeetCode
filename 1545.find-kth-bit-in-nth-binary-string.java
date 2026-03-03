class Solution {
    public char findKthBit(int n, int k) {
        return calculate(n).charAt(k-1);
    }
    String calculate(int i) {
        if(i == 1) {
            return "0";
        }

        String str = calculate(i-1);
        return str + "1" + new StringBuilder(inverse(str)).reverse().toString();
    }

    public String inverse(String str) {
        StringBuilder sb = new StringBuilder();

        for(char ch : str.toCharArray()) {
            if(ch == '0') {
                sb.append('1');
            } else {
                sb.append('0');
            }
        }
        return sb.toString();
    }
}