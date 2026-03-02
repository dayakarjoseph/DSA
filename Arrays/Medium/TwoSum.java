package Arrays;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    // BRUTE FORCE
    public static boolean twoSumBoolean(int arr[],int target){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]+arr[j]==target){
                    return true;
                }
            }
        }
        return false;
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] ans = {-1,-1};
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i] + nums[j] == target){
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        return ans;
    }

    public static int[] twoSum3(int[] nums,int target){
        int[] arr = {-1,-1};
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target - nums[i])){
                arr[0] = map.get(target - nums[i]);
                arr[1] = i;
                break;
            }
            map.put(nums[i],i);
        }
        return arr;
    }

    public static int[] twoSum4(int[] nums,int target){
       int[][] numsWithIndex = new int[nums.length][2];
       int arr[] = {-1,-1};
       for(int i=0;i< nums.length;i++){
           numsWithIndex[i][0] = nums[i];
           numsWithIndex[i][1] = i;
       }
        Arrays.sort(numsWithIndex, (a,b)->Integer.compare(a[0],b[0]));
       int left = 0;
       int right = nums.length-1;
       while(left<right){
           int sum = numsWithIndex[left][0] + numsWithIndex[right][0];
           if(sum == target){
               arr[0] = numsWithIndex[left][1];
               arr[1] = numsWithIndex[right][1];
           }else if(sum>target){
               right--;
           }else{
               left++;
           }
       }
       return arr;
    }

    public static void main(String[] args) {
        int arr[] = {3,2,4};
        int ans[] = twoSum4(arr,6);
        for(int i: ans){
            System.out.print(i + " ");
        }
    }
}
