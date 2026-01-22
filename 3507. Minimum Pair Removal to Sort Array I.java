import java.util.ArrayList;
import java.util.List;

class Solution {
    public int minimumPairRemoval(int[] nums) {
        int count=0;

        List<Integer> list= new ArrayList<>();
        for(int num:nums){
            list.add(num);
        }       
        while(!checkOrder(list)){
            int minIndex=-1;
            int sum=Integer.MAX_VALUE;
            for(int i=1;i<list.size();i++){
                int adjsum=list.get(i) + list.get(i-1);
                if(adjsum <sum){
                    sum= adjsum;
                    minIndex=i-1;
                }
            }
            if(minIndex !=-1){
                list.remove(minIndex+1);
                list.set(minIndex,sum);
                count++;
            }
        }
        return count;
    }
    boolean checkOrder(List<Integer> list){
        for(int i=1;i<list.size(); i++){
            if(list.get(i)< list.get(i-1)){
                return false;
            }
        }
        return true;
    }
}