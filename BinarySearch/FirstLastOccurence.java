public class FirstLastOccurence {

    // Better with time complexity 2*O(logn) with upper bound and lower bound
    public static int firstOccurence(int arr[],int x){
        int n = arr.length;
        int low = 0;
        int high = n-1;
        int lowerBound = n;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid] >= x){
                lowerBound = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return lowerBound;
    }

    public static int lastOccurence(int arr[],int x){
        int n = arr.length;
        int low = 0;
        int high = n-1;
        int upperBound = n;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid] > x){
                upperBound = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return upperBound;
    }

     public static  int[] searchRange(int[] nums, int target) {
       int lb  = firstOccurence(nums, target);
       if(lb == nums.length || nums[lb] != target){
        return new int[]{-1,-1};
       }else{
        return new int[]{lb,lastOccurence(nums,target)-1};
       }
    }


    // with clean binary search without lower bound and upper bound
    public static int firstOcc(int arr[],int x){
        int low = 0;
        int high = arr.length-1;
        int first = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid] == x){
                first = mid;
                high = mid-1;
            }else if(arr[mid]<x){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return first;
    }

    public static int lastOcc(int arr[],int x){
        int low = 0;
        int high = arr.length-1;
        int last = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid] == x){
                last = mid;
                low = mid+1;
            }else if(arr[mid]<x){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return last;
    }

    public static int[] firstLastOcc(int nums[],int target){
        int first = firstOcc(nums, target);
        if(first == -1){
            return new int[]{-1,-1};
        }else{
            return new int[]{first,lastOcc(nums, target)};
        }
    }


    public static void main(String[] args) {
        int arr[] = {5,7,7,8,8,10};
        int target = 8;
        int[] ans = searchRange(arr, target);
        System.out.println(ans[0]+ " " + ans[1]);
        System.out.println(firstOccurence(arr, target));
        System.out.println(lastOccurence(arr, target));
    }
}
