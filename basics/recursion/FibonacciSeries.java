package recursion;

public class FibonacciSeries {
    
    public static void fibonacciSeries(int n){
        int firstTerm = 0;
        int secondTerm = 1;
        System.out.print(firstTerm + " " + secondTerm + " ");
        for(int i=2;i<=n;i++){
            int thirdTerm = firstTerm + secondTerm;
            System.out.print(thirdTerm + " ");
            firstTerm = secondTerm;
            secondTerm = thirdTerm;
        }
    }

    // Recursion TC O(2^n)
    public static int fibonacciSeriesRec(int n){
        if(n==0 || n==1){
            return n;
        }
        return fibonacciSeriesRec(n-1)+fibonacciSeriesRec(n-2);
    }

    public static void main(String[] args) {
        int n = 6;  // index based on 0
        int ans = fibonacciSeriesRec(n);
        System.out.println(ans);
    }
}
