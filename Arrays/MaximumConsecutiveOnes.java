package Arrays;

public class MaximumConsecutiveOnes {
    public static int maxConsecutiveOnes(int[] arr){
        int maximum = 0;
        int cnt = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == 1){
                cnt++;
                maximum = Math.max(maximum,cnt);
            }else{
                cnt = 0;
            }
        }
        return maximum;
    }
    public static void main(String[] args) {
        int[] arr = {1,0,1,1,0,1};
        System.out.println("The maximum number of consecutive ones is " + maxConsecutiveOnes(arr));
    }
}
