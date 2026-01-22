package sortingalgorithms;

public class QuickSort {

    public static void quickSort(int arr[],int low,int high){
        if(low<high){
            int partition = sort(arr,low,high);
            quickSort(arr,low,partition-1);
            quickSort(arr,partition+1,high);
        }
    }

    public static int sort(int arr[],int low,int high){
        int i = low;
        int j = high;
        int pivot = arr[low];
        while(i<j){
            while(arr[i] <= pivot && i<high){
                i++;
            }
            while (arr[j]>pivot && j>low){
                j--;
            }
            if(i<j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[j];
        arr[j] = arr[low];
        arr[low] = temp;
        return j;
    }
    public static void main(String[] args) {
        int arr[] = {4,5,6,7,8,9,7,2,1,8,9,3};
        quickSort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
}
