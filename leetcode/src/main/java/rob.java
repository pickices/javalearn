import java.util.Arrays;

public class rob {

    public static void main(String[] args) {
        int[] nums={2,7,9,3,1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        if(nums.length==1)
            return nums[0];
        int[] memo = new int[2];
        memo[0] = nums[0];
        memo[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            int max = Math.max(nums[i]+memo[0],memo[1]);
            memo[0] = memo[1];
            memo[1] = max;
        }
        return memo[1];
    }
}
