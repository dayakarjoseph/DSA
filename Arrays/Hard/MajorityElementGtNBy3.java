package Arrays.Hard;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementGtNBy3 {

    public static List<Integer> majorityElement(int nums[]) {
        int n = nums.length;
        List<Integer> elements = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            int ele = nums[i];
            if (elements.size() == 0
                    || elements.get(0) != nums[i] && (elements.size() < 2 || elements.get(1) != nums[i])) {
                for (int j = 0; j < nums.length; j++) {
                    if (nums[j] == ele) {
                        cnt++;
                    }
                }
            }
            if (cnt > n / 3) {
                elements.add(ele);
            }
        }

        return elements;

    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 1, 1, 3, 2};
        List<Integer> elements = majorityElement(nums);
        System.out.println(elements);
    }
}
