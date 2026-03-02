package Arrays.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MajorityElement {
    public static int majorityElement(int[] nums){
        int n = nums.length;
       for(int i=0;i<n;i++){
           int cnt = 0;
           int ele = nums[i];
           for(int j=0;j<n;j++){
               if(nums[i] == nums[j]){
                   cnt++;
                   if(cnt>n/2){
                       return ele;
                   }
               }
           }
       }
       return -1;
    }

    public static int majorityElementFreq(int[] nums){
        int maxi = 0;
        int majorityElement = 0;
        int n = nums.length;
        for (int num : nums) {
            maxi = Math.max(maxi, num);
        }
        int[] freq = new int[maxi+1];
        for (int num : nums) {
            freq[num]++;
        }
        for(int i=0;i<freq.length;i++){
            if(freq[i] > n/2){
                majorityElement = i;
            }
        }
        return majorityElement;
    }

    public static int majorityElementMap(int[] nums){
        int n = nums.length;
        int majority = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() > n/2){
                majority = entry.getKey();
            }
        }
        return majority;
    }

    // Moores voting algorithm
    public static int majorityElementMVA(int[] nums){
        int element = 0;
        int cnt = 0;
        for(int i=0;i<nums.length;i++){
            if(cnt == 0){
                element = nums[i];
                cnt = 1;
            }else if(element == nums[i]){
                cnt++;
            }else{
                cnt--;
            }
        }
        int cnt1 = 0;
        for(int i=0;i<nums.length;i++){
            if(element == nums[i]){
                cnt1++;
            }
        }
        if(cnt1>nums.length/2){
            return element;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {7,7,5,7,5,1,5,7,5,5,7,7,5,5,5,5};
        System.out.println(majorityElementMVA(nums));
    }
}
