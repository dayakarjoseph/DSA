package BinarySearch;

public class SingleElementInSortedArr {

    // Brute force approach
    public static int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (nums[i] != nums[i + 1]) {
                    return nums[i];
                }
            } else if (i == n - 1) {
                if (nums[i] == nums[i - 1]) {
                    return nums[i];
                }
            } else {
                if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    // Optimal approach

    public static int singleElement(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }else if(nums[0] != nums[1]){
            return nums[0];
        }else if(nums[n-1] != nums[n-2]){
            return nums[n-1];
        }else{
            int low = 1;
            int high = n-2;
            while(low<=high){
                int mid = low+(high-low)/2;
                if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]){
                    return nums[mid];
                }else if(nums[mid] == nums[mid-1]){
                    if((mid-1)%2==0 && mid%2==1){
                        low = mid+1;
                    }else{
                        high = mid-1;
                    }
                }else{
                    if(mid%2==1 && (mid+1)%2==0){
                        high = mid-1;
                    }else{
                        low = mid+1;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 7,7,10,11,11,12,12 };
        System.out.println("The Single element in the array is : " + singleElement(arr));
    }
}