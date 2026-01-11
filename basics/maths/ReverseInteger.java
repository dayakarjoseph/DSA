package maths;

import java.util.Scanner;

public class ReverseInteger {
    public static int reverseInteger(int x){
        int reverseNumber = 0;
        int number = x;
        if(x < 0){
            number = -x;
        }
        //O(log10(n))
        while(number>0){
            int digit = number%10;
            if(reverseNumber > Integer.MAX_VALUE/10 ||( reverseNumber==Integer.MAX_VALUE/10 && digit>7)){
                return 0;
            }
            if(reverseNumber < Integer.MIN_VALUE/10 || (reverseNumber == Integer.MIN_VALUE/10 && digit<-8)){
                return 0;
            }
            reverseNumber =( reverseNumber*10)+digit;
            number = number/10;
        }
        return x>0?reverseNumber:-reverseNumber;
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the number: ");
            int number = sc.nextInt();
            System.out.println("Reversed number of " + number + " : " + reverseInteger(number));
        }
    }
}
