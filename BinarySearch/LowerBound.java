public class LowerBound{
    public static int getLowerBound(int arr[],int x){
        for(int i=0;i<arr.length;i++){
            if(arr[i] >= x){
                return i;
            }
        }
        return arr.length;
    }

    // Using Binary Search
    public static int getLowerBound2(int arr[],int x){
        int low = 0;
        int high = arr.length-1;
        int ans = arr.length;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid] >= x){
                ans = mid;
                high = mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {3,5,8,9,15,19};
        System.out.println(getLowerBound2(arr, 9));
    }
}