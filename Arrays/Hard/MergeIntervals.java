package Arrays.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

  public static List<List<Integer>> merge(int[][] intervals) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        for(int i=0;i<intervals.length;i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
           if(!ans.isEmpty() && end<=ans.get(ans.size()-1).get(1)){
            continue;
           }
           for(int j=i+1;j<intervals.length;j++){
            if(intervals[j][0] <= end){
                end = Math.max(end, intervals[j][1]);
            }else{
                break;
            }
           }
            ans.add(Arrays.asList(start,end));

        }
        return ans;
    }

    public static List<List<Integer>> mergeIntervals(int[][] intervals){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        for(int[] interval: intervals){
            if(ans.isEmpty() || ans.get(ans.size()-1).get(1)<interval[0]){
                ans.add(Arrays.asList(interval[0],interval[1]));
            }else{
                int lastElements = ans.size()-1;
                int maxElement = Math.max(ans.get(lastElements).get(1),interval[1]);
                ans.get(lastElements).set(1, maxElement);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int intervals[][] = {{1,3},{2,6},{8,10},{15,18}};
        List<List<Integer>> ans = merge(intervals);
        System.out.println(ans);
    }
}
