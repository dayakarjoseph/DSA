package Arrays.Hard;

import java.util.HashMap;

public class SubArraysXorK {

    public static int countSubArraysXorK(int arr[],int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int cnt = 0;
        int xor = 0;
        map.put(0,1);
        for(int i=0;i<arr.length;i++){
            xor = xor^arr[i];
            if(map.containsKey(xor^k)){
                cnt += map.get(xor^k);
            }
            map.put(xor,map.getOrDefault(xor, 0)+1);
        }
        return cnt;
    }
    public static void main(String[] args) {
        int arr[] = {4,2,2,6,4};
        int cnt = countSubArraysXorK(arr, 6);
        System.out.println(cnt);
    }
}
