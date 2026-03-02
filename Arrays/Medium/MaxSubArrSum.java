package Arrays.Medium;

public class MaxSubArrSum {

    public static int maxArrSum(int nums[]){
        int maxSum = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                int sum = 0;
                for(int k=i;k<=j;k++){
                    sum += nums[k];
                }
                maxSum = Math.max(sum,maxSum);;
            }
        }
        return maxSum;
    }

    public static int maxArrSumKadanes(int nums[]){
        int sum = 0;
        int maxi = Integer.MIN_VALUE;
        int start = 0;
        int ansStart = -1;
        int ansEnd = -1;
        for(int i=0;i<nums.length;i++){
            if(sum == 0) {
                start = i;
            }
            sum = sum+nums[i];
//            maxi = Math.max(sum,maxi);
            if(sum>maxi){
                maxi = sum;
                ansStart = start;
                ansEnd = i;
            }
            if(sum<0){
                sum = 0;
            }
        }
        for(int i=ansStart;i<=ansEnd;i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        return maxi;
    }
    public static void main(String[] args) {
        int[] nums = {5,4,-1,7,8};
        System.out.println(maxArrSumKadanes(nums));
    }
}
