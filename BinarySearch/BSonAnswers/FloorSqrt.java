package BinarySearch.BSonAnswers;

public class FloorSqrt {
    public static int floorSqrt(int num){
        int low = 1;
        int high = num;
        int ans = 1;
        while(low<=high){
            int mid = (low+high)/2;
            if(mid*mid <= num){
                ans = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int n = 36;
        System.out.println("the sqrt of " + n + " is : "+ floorSqrt(n));
    }
}
