
import java.util.ArrayList;
import java.util.List;

// Print All permutations
public class Permutations {
    //approach 1 using frequency method
    public static List<List<Integer>> printPermutations(int arr[]){
        List<List<Integer>> ans = new ArrayList<>();
        // helperPrintPerm(arr, ans, new ArrayList<>(), new boolean[arr.length]);
        helperPrintPerm2(arr, ans, 0);
        return ans;
    }
    public static void helperPrintPerm(int arr[],List<List<Integer>> ans,List<Integer> ds,boolean freq[]){
        if(ds.size() == arr.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(!freq[i]){
                freq[i] = true;
                ds.add(arr[i]);
                helperPrintPerm(arr, ans, ds, freq);
                ds.remove(ds.size()-1);
                freq[i] = false;
            }
        }
    }

    // approach 2
    public static void helperPrintPerm2(int arr[],List<List<Integer>> ans,int ind){
        if(ind == arr.length){
            List<Integer> ds = new ArrayList<>();
            for(int i=0;i<arr.length;i++){
                ds.add(arr[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=ind;i<arr.length;i++){
            swap(i, ind, arr);
            helperPrintPerm2(arr, ans, ind+1);
            swap(i, ind, arr);
        }
    }
    public static void swap(int i,int j,int arr[]){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3};
        List<List<Integer>> ans = printPermutations(arr);
        for(List<Integer> list: ans){
            System.out.println(list);
        }
        
    }
}
