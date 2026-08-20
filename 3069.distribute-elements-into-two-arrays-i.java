import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> resultArray(List<Integer> v) {
        int n = v.size();
        List<Integer> ans = new ArrayList<>();
        List<Integer> v1 = new ArrayList<>();
        List<Integer> v2 = new ArrayList<>();
        v1.add(v.get(0));
        v2.add(v.get(1));
        for (int i = 2; i < n; i++) {
            if (v1.get(v1.size() - 1) > v2.get(v2.size() - 1))
                v1.add(v.get(i));
            else
                v2.add(v.get(i));
        }
        ans.addAll(v1);
        ans.addAll(v2);
        return ans;
    }
}
