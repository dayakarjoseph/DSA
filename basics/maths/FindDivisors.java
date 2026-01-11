package maths;
import java.util.ArrayList;
import java.util.Collections;

public class FindDivisors {

    public static int[] printAllDivisors(int n){
        ArrayList<Integer> nums = new ArrayList<>();
        //O(sqrt(n))
        for(int i=1;i<=Math.sqrt(n);i++){
            if(n%i == 0){
                nums.add(i);
                if(n/i != i){
                    nums.add(n/i);
                }
            }
        }
        //O(nlogn)
        Collections.sort(nums);
        int ans[] = new int[nums.size()];
        //(O(n))
        for(int i=0;i<nums.size();i++){
            ans[i] = nums.get(i);
        }
        return ans;
    }
    public static void main(String[] args) {
        int n = 36;
        int ans[] = printAllDivisors(n);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i] + " ");
        }
    }
}
