package recursion;

public class SumFirstNNums {

    public static int NnumbersSum(int n) {
        if (n < 1) {
            return 0;
        }
        return n+NnumbersSum(n-1);
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println("The sum of first " + n + " numbers is " + NnumbersSum(n));
    }
}
