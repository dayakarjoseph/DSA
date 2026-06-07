
import java.util.ArrayList;

// Median of two sorted arrays
public class Median {

    // Brute
    public static int medianOfarrays(int arr1[], int arr2[]) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        int n = arr1.length, m = arr2.length;
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                list.add(arr1[i]);
                i++;
            } else {
                list.add(arr2[j]);
                j++;
            }
        }
        while (i < n) {
            list.add(arr1[i]);
            i++;
        }
        while (j < m) {
            list.add(arr2[j]);
            j++;
        }
        for (Integer el : list) {
            System.out.print(el + " ");
        }
        System.out.println();
        int size = list.size();
        if (size % 2 == 0) {
            int el1 = list.get(size / 2);
            int el2 = list.get((size / 2) - 1);
            int sum = (el1 + el2) / 2;
            return sum;
        } else {
            return list.get(size / 2);
        }
    }

    // Better to optimize the space
    public static int median(int arr1[], int arr2[]) {
        int cnt = 0;
        int i = 0, j = 0;
        int n1 = arr1.length;
        int n2 = arr2.length;
        int n = n1 + n2;
        int indx1 = (n / 2) - 1;
        int indx2 = n / 2;
        int el1 = -1, el2 = -1;
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                if (cnt == indx1)
                    el1 = arr1[i];
                if (cnt == indx2)
                    el2 = arr1[i];
                cnt++;
                i++;
            } else {
                if (cnt == indx1)
                    el1 = arr2[j];
                if (cnt == indx2)
                    el2 = arr2[j];
                cnt++;
                j++;
            }
        }
        while (i < n1) {
            if (cnt == indx1)
                el1 = arr1[i];
            if (cnt == indx2)
                el2 = arr1[i];
            cnt++;
            i++;
        }
        while (j < n2) {
            if (cnt == indx1)
                el1 = arr2[j];
            if (cnt == indx2)
                el2 = arr2[j];
            cnt++;
            j++;
        }
        if(n%2 == 0){
            return (el1 + el2)/2;
        }else{
            return el2;
        }
    }

    // Optimal using binary search
    public static double medianOfSortedArrays(int arr1[],int arr2[]){
        int n1 = arr1.length;
        int n2 = arr2.length;
        int n = n1+n2;
        if(n1>n2) return medianOfSortedArrays(arr2, arr1);
        int low = 0;
        int high = n1;
        int left = (n1+n2+1)/2;
        while(low<=high){
            int mid1 = (low+high)/2;
            int mid2 = left-mid1;
            int l1 = Integer.MIN_VALUE,l2 = Integer.MIN_VALUE;
            int  r1 = Integer.MAX_VALUE,r2= Integer.MAX_VALUE;
            if(mid1<n1) r1 = arr1[mid1];
            if(mid2<n2) r2 = arr2[mid2];
            if(mid1-1>=0) l1 = arr1[mid1-1];
            if(mid2-1>=0) l2 = arr2[mid2-1];
            if(l1<=r2 && l2<=r1){
                if(n%2==0){
                return (double)(Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                }else{
                    return (Math.max(l1,l2));
                }
            }else if(l1>r2){
                high = mid1-1;
            }else{
                low = mid1+1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int arr1[] = { 1,3 };
        int arr2[] = { 2 };
        double ans = medianOfSortedArrays(arr1, arr2);
        System.out.println("The median of two arrays is " + ans);
    }
}
