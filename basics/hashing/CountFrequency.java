package hashing;

public class CountFrequency {

    public static void countNumbers(int arr[]){
        int n = arr.length;
        boolean vis[] = new boolean[n];
        for(int i=0;i<n;i++){
            if(vis[i]){
                continue;
            }
            int cnt = 1;
            for(int j=i+1;j<n;j++){
                if(arr[i] == arr[j]){
                    vis[j] = true;
                    cnt++;
                }
            }
            System.out.println(arr[i] + ":" + cnt);
        }
    }

    public static void main(String args[]){
        int arr[] = {2,2,3,4,4,2};
        countNumbers(arr);
    }
}
