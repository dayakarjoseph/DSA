package recursion;

public class ReverseArray {

    // Using For Loop
    public static void reverse(int arr[], int n) {
        for(int i=0;i<n/2;i++){
            int temp = arr[i];
            arr[i] = arr[n-i-1];
            arr[n-i-1] = temp;
        }
    }

    // Using Recursions with one pointer
    public static void reverseRec(int i,int n, int arr[]){
        if(i>=n/2){
            return;
        }
        swap(arr,i,n-i-1);
        reverseRec(i+1, n, arr);
    }

    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        // reverse(arr, arr.length);
        reverseRec(0, arr.length, arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
}
