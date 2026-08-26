class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        List<String> list = new ArrayList<>();
        for(int i=0;i<n;i++)
            {
                StringBuilder sb = new StringBuilder();
                int count=0;
                for(int j=i;j<n;j++)
                    {
                        sb.append(s.charAt(j));
                        if(s.charAt(j)=='1')count++;
                        if(count == k)list.add(sb.toString());
                        if(count>k)break;
                    }
            }

        if(list.size()==0)return "";
        list.sort((a,b)->
                  {
                      if(a.length()!=b.length())
                      {
                          return b.length()-a.length();
                      }
                      return b.compareTo(a);
                  });
        return list.get(list.size()-1);
    }
}