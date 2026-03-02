package Arrays.Easy;

public class SecondLargestElement {

    public static int secondLargest(int[] arr){
        int largest = Integer.MIN_VALUE;
        int second_largest = -1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>largest){
                second_largest = largest;
                largest = arr[i];
            }else if(arr[i]>second_largest && arr[i] != largest){
                second_largest = arr[i];
            }
        }
        return second_largest;
    }

    public static int secondSmallest(int[] arr){
        int smallest = Integer.MAX_VALUE;
        int second_smallest = -1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<smallest){
                second_smallest = smallest;
                smallest = arr[i];
            }else if(arr[i]<second_smallest && arr[i] != smallest){
                second_smallest = arr[i];
            }
        }
        return second_smallest;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 7, 7, 5};
        int secondLargest = secondLargest(arr);
        int secondSmallest = secondSmallest(arr);
        System.out.println("Second largest number in the array is: "+ secondLargest);
        System.out.println("Second smallest number in the array is: " + secondSmallest);
    }
}
