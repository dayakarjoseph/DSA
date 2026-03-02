package Arrays;

import java.util.HashMap;

public class MaxSubArraySum {

    // BRUTE FORCE APPROACH
    public static int maxSubArraySum(int arr[],int target){
        int maxi = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                int sum = 0;
                for(int k=i;k<=j;k++){
                    sum += arr[k];
                }
                if(sum == target){
                    maxi = Math.max(maxi,j-i+1);
                }
            }
        }
        return maxi;
    }

    public static int maxSubArraySum2(int arr[],int target){
        int maxi = 0;
        for(int i=0;i<arr.length;i++){
            int sum = 0;
            for(int j=i;j<arr.length;j++){
                    sum += arr[j];
                if(sum == target){
                    maxi = Math.max(maxi,j-i+1);
                }
                }
            }
        return maxi;
    }

    public static int maxSubArraySum3(int arr[],int target){
        int maxi = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int prefix_sum = 0;
        for(int i=0;i<arr.length;i++){
            prefix_sum += arr[i];
            if(prefix_sum == target){
                maxi = Math.max(maxi,i+1);
            }
            if(map.containsKey(prefix_sum-target)){
                maxi = Math.max(maxi,i-map.get(prefix_sum-target));
            }
            if(!map.containsKey(prefix_sum)){
                map.put(prefix_sum,i);
            }
        }
        return maxi;
    }

    public static int maxSubArraySumPositives(int arr[],int target){
        int sum = 0;
        int i=0;
        int j=0;
        int len = 0;
        while(j<arr.length){
            sum+=arr[j];
            if(sum == target){
                len = Math.max(len,j-i+1);
            }
            while(i<=j && sum>target){
                sum -= arr[i];
                i++;
            }
           j++;
        }
        return len;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,1,1,1,1,2,1,4,5,6};
        System.out.println("The logest sub array sum is " + maxSubArraySumPositives(arr,6));
    }
}
