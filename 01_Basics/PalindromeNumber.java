public class PalindromeNumber {
    public static boolean isPalindrome(int x){
        return reverseInteger(x) == x;
    }
     public static int reverseInteger(int x){
        int reverseNumber = 0;
        int number = x;
        //O(log10(n))
        while(number>0){
            int digit = number%10;
            reverseNumber =( reverseNumber*10)+digit;
            number = number/10;
        }
        return reverseNumber;
    }
    public static void main(String[] args) {
        int x = 12201;
        System.out.println(x + " is a palindrome: " + isPalindrome(x));
    }
}
