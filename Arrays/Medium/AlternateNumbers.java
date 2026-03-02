package Arrays.Medium;

public class AlternateNumbers {

    public static int[] rearrangeArray(int[] nums){
        int n = nums.length;
        int j = 0;
        int k = 0;
        int rearrange[] = new int[n];
        int positives[] = new int[n/2];
        int negatives[] = new int[n/2];
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                positives[j++] = nums[i];
            }else{
                negatives[k++] = nums[i];
            }
        }
        int x = 0;
        int y = 0;
        int z = 0;
        while(x<n/2 && y<n/2){
            rearrange[z++] = positives[x];
            rearrange[z++] = negatives[y];
            x++;
            y++;
        }
        return rearrange;
    }

    public static void main(String[] args) {
        int arr[] = {-1,1};
        int ans[] = rearrangeArray(arr);
        for(int n : ans){
            System.out.print(n + " ");
        }
    }
}
