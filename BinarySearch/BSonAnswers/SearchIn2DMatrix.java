public class SearchIn2DMatrix {
    public static boolean search(int arr[][],int target){
        int n = arr.length;
        int m = arr[0].length;
        for(int i=0;i<n;i++){
            boolean found = searchRow(arr[i], target);
            if(found == false){
                continue;
            }else{
                return true;
            }
        }
        return false;
    }
    public static boolean searchRow(int arr[],int target){
        int n = arr.length;
        if(target<arr[0] && target>arr[n-1]){
            return false;
        }
            int low = 0;
            int high = n-1;
            while(low<=high){
                int mid = (low+high)/2;
                if(target == arr[mid]){
                    return true;
                }else if(target > arr[mid]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
            return false;
    }

    // optimal
    public static boolean searchElement(int arr[][],int target){
        int n = arr.length;
        int m = arr[0].length;
        int low = 0;
        int high = n*m-1;
        while(low<=high){
            int mid = (low+high)/2;
            int row = mid/m;
            int col = mid%m;
            if(arr[row][col] == target){
                return true;
            }else if(arr[row][col] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int arr[][] = {{3,4,7,9},{12,13,16,18},{20,21,23,29}};
        boolean ans = searchElement(arr, 29);
        System.out.println("Element found : " + ans);
    }
}
