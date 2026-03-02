package Arrays.Easy;

// Remove Duplicates from the sorted array
public class RemoveDuplicates {
    public static int removeDuplicates(int arr[]){
        int i=0;
        for(int j=1;j<arr.length;j++){
            if(arr[i] != arr[j]){
                i++;
                arr[i] = arr[j];
            }
        }
        return i+1;
    }
    public static void main(String[] args) {
        int arr[] = {1,1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,7,8,9,12,12};
        System.out.println("The number of unique elements in the array is : " + removeDuplicates(arr));
    }
}
