package Arrays;

public class SingleElement {

    // BRUTE FORCE APPROACH
    public static int findSingleElement(int arr[]){
        for(int i=0;i<arr.length;i++){
            int cnt = 0;
            for(int j=0;j<arr.length;j++){
                if(arr[i] == arr[j]){
                    cnt++;
                }
            }
            if(cnt == 1){
                return arr[i];
            }
        }
        return -1;
    }



    public static int findSingleElementXOR(int arr[]){
        int xor = 0;
        for(int i=0;i<arr.length;i++){
            xor = xor^arr[i];
        }
        return xor;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,3,2,1,4,5,5,6,7,7,6,8,8};
        System.out.println("The unique element in the array is : "+findSingleElementXOR(arr));
    }
}
