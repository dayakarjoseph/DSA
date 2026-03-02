package Arrays.Medium;

public class StockBuySell {
    public static int maxProfit(int[] nums){
        int maxDiffrence = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int buy = nums[i];
            int diff = 0;
            for(int j=i+1;j<nums.length;j++){
                diff = nums[j] - nums[i];
                maxDiffrence = Math.max(diff,maxDiffrence);
            }
        }
        return Math.max(maxDiffrence, 0);
    }

    public static int maxProfitOptimal(int[] nums){
        int buy = nums[0];
        int maxProfit = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<buy){
                buy = nums[i];
            }else{
                int diff = nums[i]-buy;
                maxProfit = Math.max(diff,maxProfit);
            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int arr[] = {7,6,4,3,1};
        System.out.println(maxProfitOptimal(arr));
    }
}
