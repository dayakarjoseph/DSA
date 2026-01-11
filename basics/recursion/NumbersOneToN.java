package recursion;

// Print numbers from 1 to N using recursion
// Time Complexity: O(N)
// Space Complexity: O(N) due to recursion stack
public class NumbersOneToN {
    public static void printNumbers(int i,int n){
        if(i>n){
            return;
        }
        System.out.print(i + " ");
        printNumbers(i+1,n);
    }

    // By Backtracking
    public static void printNumbersOneToN(int n){
        if(n<1){
            return;
        }
        printNumbersOneToN(n-1);
        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        int n = 5;
        printNumbers(1,n);
        System.out.println();
        printNumbersOneToN(n);
    }
}
