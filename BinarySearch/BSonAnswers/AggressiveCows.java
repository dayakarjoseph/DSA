package BinarySearch.BSonAnswers;

import java.util.Arrays;

public class AggressiveCows{

    // Linear approach
    public static int aggressiveCows(int arr[],int cows){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            min = Math.min(min,arr[i]);
            max = Math.max(max,arr[i]);
        }
        for(int i=1;i<=max-min;i++){
            if(canWePlace(arr,i,cows) == true){
                continue;
            }else{
                return i-1;
            }
        }
        return -1;
    }

    public static boolean canWePlace(int arr[],int dist,int cows){
        int cntCows = 1;
        // Arrays.sort(arr);
        int last = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i] - last >= dist){
                cntCows++;
                last = arr[i];
            }
        }
        if(cntCows >= cows){
            return true;
        }
        return false;
    }

    // Binary Search
    public static int aggressiveCows2(int arr[],int cows){
        int low = 1;
        Arrays.sort(arr);
        int high = arr[arr.length-1]-arr[0];
        while(low<=high){
            int mid = low + (high-low)/2;
            if(canWePlace(arr, mid, cows) == true){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return high;
    }
    
    public static void main(String args[]){
            int arr[] = {0,3,4,7,10,9};
            int cows = 4;
            int ans = aggressiveCows(arr, cows);
            System.out.println("The minimum distance between two of the cows maximum is: " + ans);
    }
}