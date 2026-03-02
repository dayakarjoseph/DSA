package Arrays.Easy;

public class RotateArrKPlaces {

    // Left rotation Brute Force approach
    public static void rotateArrByKplaces(int arr[],int k){
        int n = arr.length;
        k=k%n;
        int temp[] = new int[k];
        for(int i=0;i<k;i++){
            temp[i] = arr[i];
        }
        for(int i=k;i<n;i++){
            arr[i-k] = arr[i];
        }
        for(int i=n-k;i<n;i++){
            arr[i] = temp[i-(n-k)];
        }
    }

    // Right rotation Brute Force approach
    public static void rotateArrByDPlaces(int arr[],int d){
        int n = arr.length;
//        d = d%n;
        int temp[] = new int[d];
        for(int i=n-d;i<n;i++){
            temp[i-(n-d)] = arr[i];
        }
        for(int i=n-d-1;i>=0;i--){
            arr[i+d] = arr[i];
        }
        for(int i=0;i<d;i++){
            arr[i] = temp[i];
        }
    }


    public static void reverse(int arr[],int start,int end){
        int i=start;
        int j=end;
        while(i<=j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void rotateLeftByKPlaces(int arr[],int k){
        reverse(arr,0,k-1);
        reverse(arr,k,arr.length-1);
        reverse(arr,0,arr.length-1);
    }

    public static void rotateRightByKPlaces(int arr[],int k){
        reverse(arr,0,arr.length-1);
        reverse(arr,0,k-1);
        reverse(arr,k,arr.length-1);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
//        rotateArrByDPlaces(arr,2);
        rotateRightByKPlaces(arr,3);
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}
