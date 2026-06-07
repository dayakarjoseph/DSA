
import java.util.ArrayList;

public class Subsequences {
    public static void printSubsequences(int arr[],int ind,int n,ArrayList<Integer> ans){
        if(ind >= n){
            System.out.println(ans);
            return;
        }
        ans.add(arr[ind]);
        printSubsequences(arr, ind+1, n, ans);
        ans.remove(ans.size()-1);
        printSubsequences(arr, ind+1, n, ans);
    }

    // subsequences equal to k
    public static void printSubsequencesSum(int arr[],int ind,int sum,int n,ArrayList<Integer> ans,int k){
        if(ind >= n){
        if(sum == k){
            System.out.println(ans);
        }
        return;
    }
        ans.add(arr[ind]);
        sum += arr[ind];
        printSubsequencesSum(arr, ind+1, sum, n, ans, k);
        ans.remove(ans.size()-1);
        sum -= arr[ind];
        printSubsequencesSum(arr, ind+1, sum, n, ans, k);
    }

    // print any subsequence which sum equal to k
     public static boolean printSubsequenceSum(int arr[],int ind,int sum,int n,ArrayList<Integer> ans,int k){
        if(ind >= n){
        if(sum == k){
            System.out.println(ans);
            return true;
        }
        return false;
    }
        ans.add(arr[ind]);
        sum += arr[ind];
        if(printSubsequenceSum(arr, ind+1, sum, n, ans, k) == true){
            return true;
        }
        ans.remove(ans.size()-1);
        sum -= arr[ind];
        if(printSubsequenceSum(arr, ind+1, sum, n, ans, k) == true){
            return true;
        }
        return false;
    }

    // count the subsequences with equal to k
     public static int countSubsequencesSum(int arr[],int ind,int sum,int n,int k){
        if(ind >= n){
        if(sum == k){
            return 1;
        }
        return 0;
    }
        sum += arr[ind];
        int l =  countSubsequencesSum(arr, ind+1, sum, n, k);
        sum -= arr[ind];
        int r = countSubsequencesSum(arr, ind+1, sum, n, k);
        return l+r;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,1};
        ArrayList<Integer> ans = new ArrayList<>();
        // printSubsequences(arr, 0, arr.length, ans);
        int sum = 0;
        // printSubsequencesSum(arr, 0, sum, arr.length, ans, 2);
        // printSubsequenceSum(arr, 0, sum, arr.length, ans, 2);
        int totalSubSeq = countSubsequencesSum(arr, 0, sum, arr.length, 2);
        System.out.println("Total number of subSeq sum equal to k :" + totalSubSeq);
    }
}
