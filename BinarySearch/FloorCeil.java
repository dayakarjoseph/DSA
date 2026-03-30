public class FloorCeil{
    public static int floor(int arr[],int x){
        int n = arr.length;
        int low = 0;
        int high = n-1;
        int floor = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]<=x){
                floor = arr[mid];
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return floor;
    }

    public static int ceil(int arr[],int x){
        int n = arr.length;
        int low = 0;
        int high = n-1;
        int ceil = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]<x){
                low=mid+1;
            }else{
                ceil = arr[mid];
                high = mid-1;
            }
        }
        return ceil;
    }
    public static void main(String[] args) {
        int arr[] = {3,4,4,7,8,10};
        int x = 5;
        System.out.println(floor(arr, x));
        System.out.println(ceil(arr, x));
    }
}