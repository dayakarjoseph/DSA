package recursion;

public class StringPalindrome {

    public static boolean isPalindrome(String str){
        int size = str.length();
        for(int i=0;i<size/2;i++){
            if(str.charAt(i) != str.charAt(size-i-1)){
                return false;
            }
        }
        return true;
    }

    // Using recursion
    public static boolean isPalindrome2(String str,int n,int i){
        if(i>=n/2){
            return true;
        }
        if(str.charAt(i) != str.charAt(n-i-1)){
            return false;
        }
        return isPalindrome2(str, n, i+1);
    }


    // Two pointers
    public static boolean isPalindrome3(String s){
        int left = 0;
        int right = s.length()-1;
        while(left < right){
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        System.out.println(str + " is palindrome " + isPalindrome3(str));
    }
}
