package level1;

import java.util.*;
import java.util.stream.Collectors;

public class phoneketmon {
    private static int[] arr = {3,3,1,2};
    public static void main(String[] args) {
       System.out.println(solution(arr));
    }
    private static int solution(int[] nums) {
        int answer = 0;
        Set set = new HashSet<Integer>();
        set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        return nums.length/2 > set.size() ? set.size() : nums.length/2;
    }
}
