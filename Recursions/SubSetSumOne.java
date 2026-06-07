
import java.util.ArrayList;
import java.util.Collections;

public class SubSetSumOne {

    public static ArrayList<Integer> subSetSum(int arr[]){
        ArrayList<Integer> ans = new ArrayList<>();
        helperSubset(arr,ans,0,0);
        Collections.sort(ans);
        return ans;
    }

    public static void helperSubset(int arr[],ArrayList<Integer> ans, int ind,int sum){
        if(ind == arr.length){
            ans.add(sum);
            return;
        }
        helperSubset(arr, ans, ind+1, sum+arr[ind]);
        helperSubset(arr, ans, ind+1, sum);
    }
    public static void main(String[] args) {
        int arr[] = {3,1,2};
        ArrayList<Integer> ans = subSetSum(arr);
        for(Integer sum: ans){
            System.out.print(sum + " ");
        }
    }
}
