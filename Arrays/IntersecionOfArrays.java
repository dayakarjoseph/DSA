package Arrays;

import java.util.ArrayList;
import java.util.HashMap;

public class IntersecionOfArrays {
    public static ArrayList<Integer> intersectionOfArr(int arr1[],int arr2[]){
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> common = new ArrayList<>();
        for(int j: arr1){
            map.put(j,map.getOrDefault(j,0)+1);
        }
        for(int j: arr2){
            if(map.containsKey(j) && map.get(j)>0){
                common.add(j);
                map.put(j,map.get(j)-1);
            }
        }
        return common;
    }

    public static ArrayList<Integer> intersectionOfArrOptimal(int arr1[],int arr2[]){
        ArrayList<Integer> common = new ArrayList<>();
        int i=0,j=0;
        while(i<arr1.length && j<arr2.length){
            if(arr1[i] < arr2[j]){
                i++;
            }else if(arr2[j] < arr1[i]){
                j++;
            }else{
                common.add(arr1[i]);
                i++;
                j++;
            }
        }
        return common;
    }


    public static void main(String[] args) {
        int arr1[] = {1,2,2,3,3,4,5,6};
        int arr2[] = {2,3,3,5,6,6,7};
        ArrayList<Integer> ans = intersectionOfArrOptimal(arr1,arr2);
        for(Integer num : ans){
            System.out.print(num + " ");
        }
    }
}
