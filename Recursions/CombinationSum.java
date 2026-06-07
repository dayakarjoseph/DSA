
import java.util.ArrayList;

public class CombinationSum {

    public static ArrayList<ArrayList<Integer>> combinationSum(int target,int arr[]){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        helperCombination(0, target, arr, ans, new ArrayList<>());
        return ans;
    }
    public static void helperCombination(int ind,int target,int arr[],ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> ds){
        if(ind >= arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if(arr[ind] <= target){
            ds.add(arr[ind]);
            helperCombination(ind, target-arr[ind], arr, ans, ds);
            ds.remove(ds.size()-1);
        }
        helperCombination(ind+1, target, arr, ans, ds);
    }


    
    public static void main(String[] args) {
        int arr[] = {10,1,2,7,6,1,5};
        ArrayList<ArrayList<Integer>> ans = combinationSum(8, arr);
        for(ArrayList<Integer> list: ans){
            System.out.println(list);
        }
    }
}
