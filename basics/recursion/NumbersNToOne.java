package recursion;

public class NumbersNToOne {
    public static void printNumbers(int i,int n){
        if(i<1){
            return;
        }
        System.out.print(i + " ");
        printNumbers(i-1, n);
    }

    // By backtracking
    public static void printNumbersNToOne(int i, int n){
        if(i>n){
            return;
        }
        printNumbersNToOne(i+1, n);
        System.out.print(i + " ");
    }
    public static void main(String[] args) {
        int n = 5;
        printNumbers(n, n);
        System.out.println();
        printNumbersNToOne(1, n);
    }
}
