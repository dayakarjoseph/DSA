
import java.util.PriorityQueue;

public class GasStations {
    public static class Pair{
        double distance;
        int index;
        Pair(double distance, int index){
            this.distance = distance;
            this.index = index;
        }
    }
    // Brute force approach
    public static double minimizeMaxDistance(int arr[],int k){
        int n = arr.length;
        int howManySections[] = new int[n-1];
        for(int i=1;i<=k;i++){
            double maxSectionLength = -1;
            int maxInd = -1;
            for(int j=0;j<n-1;j++){
                double diff = arr[j+1] - arr[j];
                double sectionLength = diff/(howManySections[j]+1);
                if(sectionLength > maxSectionLength){
                    maxSectionLength = sectionLength;
                    maxInd = j;
                }
            }
            howManySections[maxInd]++;
        }
        double maxAns = -1;
        for (int i = 0; i < n-1; i++) {
            double diff = arr[i+1] - arr[i];
            double sectionLength = diff/(howManySections[i]+1.0);
            maxAns = Math.max(maxAns,sectionLength);
        }
        return maxAns;
    }

    // Better using priorityQueue
    public static double minimizeMaxDist(int arr[],int k){
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Double.compare(b.distance,a.distance));
        int n = arr.length;
        int howManySec[] = new int[n-1];
        for(int i=0;i<arr.length-1;i++){
            pq.add(new Pair(arr[i+1]-arr[i],i));
        }
        for(int i=1;i<=k;i++){
            Pair top = pq.poll();
            int idx = top.index;
            howManySec[idx]++;
            double totalDist = arr[idx+1] - arr[idx];
            double newDist = totalDist/(howManySec[idx]+1);
            pq.add(new Pair(newDist,idx));
        }
        return pq.peek().distance;
    }

    // Optimal Using Binary Search
    public static double minimizeMaximumDist(int arr[],int k){
        double low = 0;
        double high = 0;
        for(int i=0;i<arr.length-1;i++){
            high = Math.max(high,arr[i+1]-arr[i]);
        }
        double diff = 1e-6;
        while(high-low>diff){
            double mid = low + (high-low)/2;
            double count = countSections(mid,arr);
            if(count > k){
                low = mid;
            }else{
                high = mid;
            }
        }
        return high;
    }

    public static double countSections(double dist,int arr[]){
        int count = 0;
        for(int i=1;i<arr.length;i++){
            int numberInBetween = (int) ((arr[i]-arr[i-1])/dist);
            if(arr[i] - arr[i-1] == numberInBetween * dist){
                numberInBetween--;
            }
            count += numberInBetween;
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        System.out.println("The minimized distance of placing gas stations is " + minimizeMaximumDist(arr, 20));
    }
}
