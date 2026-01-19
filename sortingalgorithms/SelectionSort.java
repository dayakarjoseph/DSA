package sortingalgorithms;

public class SelectionSort {

    public static int[] selectionSort(int arr[]) {
        for (int i = 0; i <= arr.length - 2; i++) {
            int minimum = i; // minimum number index value
            for (int j = i; j <= arr.length - 1; j++) {
                if (arr[j] < arr[minimum]) {
                    minimum = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minimum];
            arr[minimum] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = {13, 46, 24, 52, 20, 9};
        int nums[] = selectionSort(arr);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
