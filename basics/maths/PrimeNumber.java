package maths;

public class PrimeNumber {
    public static boolean isPrime(int n){
        int cnt = 0;
        for(int i=1;i<=Math.sqrt(n);i++){
            if(n%i==0){
               cnt++;
                if(n/i != i){
                   cnt++;
                }
            }
        }
       return cnt == 2;
    }
    public static void main(String[] args) {
        int n = 15;
        System.out.println(n + " is a prime number: " + isPrime(n));
    }
}
