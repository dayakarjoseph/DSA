package recursion;

import java.util.Scanner;

public class NameNTimes {
    public static void printNTimes(int i,int n){
        if(i>n){
            return;
        }
        System.out.println("Dayakar");
        printNTimes(i+1, n);
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            printNTimes(1, n);
        }
    }
}
