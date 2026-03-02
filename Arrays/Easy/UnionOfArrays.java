package Arrays.Easy;

import java.util.ArrayList;
import java.util.HashMap;

public class UnionOfArrays {
    public static ArrayList<Integer> unionOfArrays(int[] arr1, int[] arr2){
        HashMap<Integer,Integer> map = new HashMap<>(); // or Tree Map for sorted array
        ArrayList<Integer> union = new ArrayList<>();
        for (int j : arr1) {
          map.put(j,map.getOrDefault(j,0)+1);
        }
        for(int j: arr2){
            map.put(j,map.getOrDefault(j,0)+1);
        }
        for(Integer key : map.keySet()) union.add(key);
        return union;
    }

    public static ArrayList<Integer> unionOfArraysOptimal(int[] arr1,int[] arr2){
        int i=0,j=0;
        ArrayList<Integer> union = new ArrayList<>();
        while(i<arr1.length && j<arr2.length){
            if(arr1[i] <  arr2[j]){
                if(union.isEmpty() || union.get(union.size()-1) != arr1[i]) {
                    union.add(arr1[i]);
                }
                i++;
            }else if(arr1[i] > arr2[j]){
                if(union.isEmpty() || union.get(union.size()-1) != arr2[j]){
                    union.add(arr2[j]);
                }
                j++;
            }else{
                if(union.isEmpty() || union.get(union.size()-1) != arr1[i]) {
                    union.add(arr1[i]);
                }
                i++;
                j++;
            }
        }
        while(i<arr1.length){
            if(union.isEmpty() || union.get(union.size()-1) != arr1[i]) {
                union.add(arr1[i]);
            }
            i++;
        }
        while(j<arr2.length){
            if(union.isEmpty() || union.get(union.size()-1) != arr2[j]){
                union.add(arr2[j]);
            }
            j++;
        }
        return union;
    }
    public static void main(String[] args) {
        int[] arr1 = {1,1,2,3,4,5};
        int[] arr2 = {2,3,4,4,5};
        ArrayList<Integer> union = unionOfArraysOptimal(arr1,arr2);
        for(Integer num : union){
            System.out.print(num + " ");
        }
    }
}
