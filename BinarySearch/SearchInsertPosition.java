package BinarySearch;

public class SearchInsertPosition {
    public static int searchInsert(int arr[],int x){
        int ans = -1;
       for(int i=0;i<arr.length;i++){
        if(arr[i] == 6){
            ans = i;
            break;
        }
       }
       if(ans == -1){
        if(x<arr[0]){
            ans = 0;
        }
        if(x>arr[arr.length-1]){
            ans=arr.length-1+1;
        }
        for(int i=1;i<arr.length;i++){
            if(arr[i-1] < x && arr[i] > x){
                ans = i;
            }
        }
       }
       return ans;
    }

    public static int searchInsert2(int arr[],int x){
        int n = arr.length;
        int ans = n;
        int low = 0;
        int high= n-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]>=x){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int arr[] = {1,2,4,7};
        int x = 8;
        System.out.println(searchInsert(arr, x));
    }
}
