import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsTwo {
 public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        subsets(nums,0,ans,new ArrayList<>());
        return ans;
    }

    public static void subsets(int nums[], int ind, List<List<Integer>> ans, List<Integer> ds) {
        ans.add(new ArrayList<>(ds));
        for(int i=ind;i<nums.length;i++){
            if(i!=ind && nums[i] == nums[i-1]) continue;
            ds.add(nums[i]);
            subsets(nums,i+1,ans,ds);
            ds.remove(ds.size()-1);
        }
    }

    public static void main(String[] args) {
        
    }
}
