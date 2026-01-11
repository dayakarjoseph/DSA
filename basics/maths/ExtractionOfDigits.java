package maths;
public class ExtractionOfDigits {

    // Time Complexity O(log10(n))
    public void extractDigitsFromLastToFirst(int number){
        int n = number;
        while(n>0){
            int remainder = n%10;
            System.out.print(remainder + " ");
            n=n/10;
        }
    }

    public static void extractDigitsFromFirstToLast(int number){
        int digits = (int)Math.log10(number);  // number of digits-1 or To count digits (digits+1)
        int divisor = (int) Math.pow(10,digits);
        int n=number;
        int i=1;
        while(divisor>0){
            int digit = n/divisor;
            System.out.println("digit "+ i + " : " + digit);
            n = n%divisor;
            divisor = divisor/10;
            i++;
        }
    }

    public static void main(String[] args) {
        int number = 9877;
        ExtractionOfDigits digits = new ExtractionOfDigits();
        digits.extractDigitsFromLastToFirst(number);
        System.out.println();
        extractDigitsFromFirstToLast(number);
    }
}
