package Arrays;

public class MissingNumber {
    public static int missingNumber(int arr[]){
        int n = arr.length;
        int missing = 0;
        int[] freq = new int[n+1];
        for(int i=0;i<arr.length;i++){
            freq[arr[i]]+=1;
        }
        for(int i=0;i<freq.length;i++){
            if(freq[i] == 0){
                missing = i;
            }
        }
        return missing;
    }

    public static int missingNumber2(int arr[]){
        int n = arr.length+1;
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum = sum + arr[i];
        }
        int sumOfNatural = (n*(n+1))/2;
        return sumOfNatural-sum;
    }

    public static int missingNumberXOR(int[] arr){
        int n = arr.length+1;
        int xor1 = 0;
        int xor2 = 0;
        for(int i=0;i<n;i++){
            xor1 = xor1^i;
        }
        for(int j=0;j<arr.length;j++){
            xor2 = xor2^arr[j];
        }
        return xor1^xor2;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,2,4,5,6};
        int ans = missingNumberXOR(arr);
        System.out.println("The missing number in the array is: " + ans);
    }
}
