package Arrays.Easy;

public class ZeroesToEnd {
    public static void moveZeroesToEnd(int arr[]){
        int temp[] = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            int j=0;
            if(arr[i] != 0){
                temp[j++] = arr[i];
            }
        }
        for(int i=0;i<arr.length;i++){
            arr[i] = temp[i];
        }
    }


//    public static void moveZeroesToEndOptimal(int arr[]){
//        int i=0;
//        int j=0;
//        while(j<arr.length){
//            if(arr[j] != 0) {
//                int temp = arr[j];
//                arr[j] = arr[i];
//                arr[i] = temp;
//                i++;
//            }
//            j++;
//        }
//    }

    public static void moveZeroesToEndOptimal(int arr[]){
        int j = -1;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == 0){
                j=i;
                break;
            }
        }
        if(j==-1) return;
        for(int i=j+1;i<arr.length;i++){
            if(arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {0,1,0,12,13,0,14,2,0,0,6,0,3,1,0,4};
        moveZeroesToEndOptimal(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
}
