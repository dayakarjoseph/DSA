public class MaximumOnes {
    public static int maximumOne(int arr[][]){
        int max = 0;
        int ind = 0;
        int m = arr.length;
        int n = arr[0].length;
        for(int i=0;i<m;i++){
            int cnt = getCountOnes(arr[i]);
            Math.max(max,cnt);
            if(cnt > max){
                max = cnt;
                ind = i;
            }
        }
        return ind;
    }
    public static int getCountOnes(int arr[]){
        int cnt = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == 1){
                cnt++;
            }
        }
        return cnt;
    }


    // Optimal using binary search lower bound(1) or upperbound(0) or first occurence(1)
    public static int getMaximumOnesRow(int arr[][]){
        int max_cnt = 0;
        int max_ind = -1;
        int n = arr.length, m = arr[0].length;
        for(int i=0;i<n;i++){
            int count = m-lowerBound(arr[i],1);
            if(count > max_cnt){
                max_cnt = count;
                max_ind = i;
            }
        }
        return max_ind;
    }

    public static int lowerBound(int arr[],int x){
        int low = 0;
        int high = arr.length-1;
        int ans = arr.length;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid] >= x){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[][] = {{0,0,1,1,1},{0,0,0,0,0},{0,0,0,0,0},{0,1,1,1,1}};
        int ans = getMaximumOnesRow(arr);
        System.out.println("The maximum number of ones is on the row of " + ans);
    }
}
