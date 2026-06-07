package BinarySearch.BSonAnswers;

public class KokoEatingBananas {
    // Brute force approach
    public static int minEatingSpeed(int[] piles, int h) {
        int ans = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int pile: piles){
            max = Math.max(max,pile);
        }
        for(int i=1;i<=max;i++){
            int sum = 0;
            for(int j=0;j<piles.length;j++){
            int bananaPerHr = (int)Math.ceil((double) piles[j]/i);
            sum = sum + bananaPerHr;
            }
            if(sum<=h){
                ans = Math.min(ans,i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int piles[] = {3,6,7,11};
        int h = 8;
        System.out.println("The minimum eating speed is : " + minEatingSpeed(piles, h));
    }
}
