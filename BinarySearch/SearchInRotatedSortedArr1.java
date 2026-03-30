public class SearchInRotatedSortedArr1 {

    public static int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if (nums[low] == nums[mid] && nums[mid] == nums[high]){ // if there is any duplicates trim the array
                low++;
                high--;
                continue;
            }
            else if(nums[low] <= nums[mid]){
                if(nums[low]<=target && target<nums[mid]){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }else{
                if(nums[mid]<=target && target<=nums[high]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }
    public static void main(String args[]){
        int nums[] = {2,5,6,0,1,1,2};
        int target = 1;
        int ans  = search(nums, target);
        System.out.println("The index is :  " + ans);
    }
}
