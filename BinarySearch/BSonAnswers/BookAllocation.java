public class BookAllocation{
    
    public static int bookAllocation(int arr[],int m){
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            max = Math.max(max,arr[i]);
            sum = sum + arr[i];
        }
        int low = max;
        int high = sum;
        while(low<=high){
            int mid = (low + high)/2;
            int cntOfStudents = countStudents(arr,mid);
            if(cntOfStudents > m){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }

    public static int countStudents(int arr[],int pages){
        int students = 1;
        int pagesOfStudent = 0;
        for(int i=0;i<arr.length;i++){
            if(pagesOfStudent + arr[i] <= pages){
                pagesOfStudent += arr[i];
            }else{
                students++;
                pagesOfStudent = arr[i];
            }
        }
        return students;
    }

    public static void main(String args[]){
        int arr[] = {25,46,28,49,24};
        int ans = bookAllocation(arr,4);
        System.out.println("The maximum number of pages assigned to student is minimum are : " + ans);
    }
}
