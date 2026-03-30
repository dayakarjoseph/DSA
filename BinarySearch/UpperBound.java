package BinarySearch;

public class UpperBound {
    public static int upperBound(int arr[],int x){
        int low = 0;
        int high = arr.length-1;
        int ans = arr.length;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid] <= x){
                low=mid+1;
            }else{
                ans = mid;
                high = mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
         int arr[] = {3,5,8,9,15,19};
        System.out.println(upperBound(arr, 9));
    }
}
