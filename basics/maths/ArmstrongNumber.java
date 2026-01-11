package maths;
public class ArmstrongNumber {
    public boolean isArmstrong(int n){
        int digits = (int) Math.log10(n) + 1;
        int num = n;
        int sum = 0;
        //O(log10(n))
        while(num > 0){
            int digit = num%10;
            sum += Math.pow(digit, digits);
            num = num/10;
        }
        return n==sum;
    }
    public static void main(String[] args) {
        ArmstrongNumber arm = new ArmstrongNumber();
        int n = 153;
        System.out.println(n + " is Armstrong number: " + arm.isArmstrong(n));
    }
}
