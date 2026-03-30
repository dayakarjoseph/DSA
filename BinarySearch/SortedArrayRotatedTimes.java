// Similar to minimum sorted array
public class SortedArrayRotatedTimes {

    // find the minimum element in sorted rotated array
    // that's index is the answer and that many times it rotated.
    public static int arrayRotated(int nums[]){
        int low = 0;
        int n = nums.length;
        int high = n-1;
        int ans = Integer.MAX_VALUE;
        int cnt = 0;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[low]<=nums[mid]){
                if(nums[low] < ans){
                    ans = nums[low]; // for minimum element
                    cnt = low;
                }
                low = mid+1;
            }else{
                if(nums[mid]< ans){
                    ans = nums[mid]; // for min element
                    cnt = mid;
                }
                high = mid-1;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        int arr[] = {4,5,6,7,0,1,2,3};
        System.out.println("rotated times are " + arrayRotated(arr));
    }
}
