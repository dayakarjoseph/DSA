import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSumTwo {
 public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        helperCombinationSum(candidates,target,ans,0,new ArrayList<>());
        return ans;
    }
    public static void helperCombinationSum(int arr[],int target,List<List<Integer>> ans, int ind,List<Integer> ds){
        if(target == 0){
            ans.add(new ArrayList(ds));
            return;
        }
        for(int i=ind;i<arr.length;i++){
            if(i>ind && arr[i]==arr[i-1]) continue;
            if(arr[i] > target) break;
            ds.add(arr[i]);
            helperCombinationSum(arr,target-arr[i],ans,i+1,ds);
            ds.remove(ds.size()-1);
        }
    }
    public static void main(String[] args) {
        int arr[] = {10,1,2,7,6,1,5};
        List<List<Integer>> ans = combinationSum2(arr,8);
        for(List<Integer> list: ans){
            System.out.println(list);
        }
    }
}
