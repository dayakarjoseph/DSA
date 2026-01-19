package hashing;

import java.util.HashMap;

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

    public static void countNumbers2(int arr[]){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }else{
                map.put(arr[i], 1);
            }
        }
        for(Integer key: map.keySet()){
            int value = map.get(key);
            System.out.println(key + ": " + value);
        }
    }

    public static void main(String args[]){
        int arr[] = {4,4,2,2,3,2};
        // countNumbers(arr);
        countNumbers2(arr);
    }
}
