package BinarySearch.BSonAnswers;

public class MinimumDaysToMakeMbouquets {

    // BRUTE FORCE APPROACH
    public static int minDays(int[] bloomDays, int m, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int bloomDay : bloomDays) {
            min = Math.min(min, bloomDay);
        }
        for (int bloomDay : bloomDays) {
            max = Math.max(max, bloomDay);
        }
        for (int i = min; i <= max; i++) {
            if(minDaysHelper(i, m, k, bloomDays)){
                return i;
            }
        }
        return -1;
    }

    public static boolean minDaysHelper(int day, int m, int k, int[] bloomDays) {
        int cnt = 0;
        int bouq = 0;
        for (int j = 0; j < bloomDays.length; j++) {
            if (bloomDays[j] <= day) {
                cnt++;
            } else {
                cnt = 0;
            }
            if (cnt == k) {
                bouq++;
                cnt = 0;
            }
        }
        if (bouq == m) {
            return true;
        }
        return false;
    }

    // OPTIMAL APPROACH
    public static int minDaysBouquet(int bloomDays[],int m,int k){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int bloomDay : bloomDays) {
            min = Math.min(min, bloomDay);
        }
        for (int bloomDay : bloomDays) {
            max = Math.max(max, bloomDay);
        }
        int low = min;
        int high = max;
        int ans = 0;
        while(low<=high){
            int mid = (low+high)/2;
            if(minDaysBouquetHelper(mid, bloomDays, m, k)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }

    public static boolean minDaysBouquetHelper(int mid,int[] bloomDays,int m,int k){
        int cnt = 0;
        int bouquets = 0;
        for(int i=0;i<bloomDays.length;i++){
            if(bloomDays[i] <= mid){
                cnt++;
            }else{
                bouquets += (cnt/k);
                cnt=0;
            }
        }
        bouquets += (cnt/k);
        if(bouquets >= m){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int bloomDays[] = {1,10,3,10,2};
        System.out.println("Minimum days to make m bouquets are : " + minDaysBouquet(bloomDays, 2, 3));
    }
}
