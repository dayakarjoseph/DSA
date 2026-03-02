package Arrays.Easy;

public class ArraySorted {
    public static boolean isArraySorted(int arr[]){
        int drop = 0;
        int n = arr.length;
        for(int i=0;i<arr.length;i++){
            if(arr[i] > arr[(i+1)%n]){
                drop++;
                if(drop > 1){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int arr[] = {3,4,5,6,1,2};
        System.out.println("Array is sorted and rotated: " + isArraySorted(arr));
    }
}
