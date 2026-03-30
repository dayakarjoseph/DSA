public class MinimumInRotatedSortedArr {

    public static int findMin(int[] nums) {
        int low = 0;
        int n = nums.length;
        int high = n-1;
        while(low < high){
            int mid = low+(high-low)/2;
            if(nums[mid]>nums[high]){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        return nums[low];
    }

    public static int findMinimum(int[] nums){
        int low = 0;
        int high = nums.length-1;
        int ans = Integer.MAX_VALUE;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[low] <= nums[mid]){
                ans = Math.min(ans,nums[low]);
                low = mid+1;
            }else{
                ans = Math.min(ans,nums[mid]);
                high = mid-1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {4,5,6,7,0,1,2,3};
        System.out.println(findMinimum(arr));
    }
}
