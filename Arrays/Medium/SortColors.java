package Arrays.Medium;

public class SortColors {

    public static void sortColors(int[] arr){
        int zeros = 0;
        int ones = 0;
        int twos = 0;
        for (int j : arr) {
            if (j == 0) {
                zeros++;
            } else if (j == 1) {
                ones++;
            } else if (j == 2) twos++;
        }
        for(int i=0;i<zeros;i++){
            arr[i] = 0;
        }
        for(int i=zeros;i<zeros+ones;i++){
            arr[i] = 1;
        }
        for(int i=ones+twos;i<arr.length;i++){
            arr[i] = 2;
        }
    }

    public static void sortColors2(int[] arr){
        int low = 0,mid=0,high=arr.length-1;
        while(mid<=high){
            if(arr[mid] == 0){
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            }else if(arr[mid] == 1){
                mid++;
            }else{
                int temp = arr[high];
                arr[high] = arr[mid];
                arr[mid] = temp;
                high--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};
        sortColors2(arr);
        for(int i : arr){
            System.out.print(i + " ");
        }
    }
}
