package hashing;

import java.util.Scanner;

public class CharacterHashing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String str = sc.nextLine();
        int hash[] = new int[26];
        for(int i=0;i<str.length();i++){
            hash[str.charAt(i)-'a']++;
        }
        System.out.println("Enter the number of characters: ");
        int q = sc.nextInt();
        while(q>0){
            System.out.println("Enter the character: ");
            char ch = sc.next().charAt(0);
            System.out.println(hash[ch-'a']);
            q--;
        }
    }
}
