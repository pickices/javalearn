import java.util.Arrays;

public class MaxSubArray {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3};
        int max = Integer.MIN_VALUE;
        System.out.println(dp(nums,max));
    }

    public static int dp(int[] nums,int max){
        if(nums.length==1)
            return nums[0];
        for(int i =0;i<nums.length;i++){
            int[] nums_temp = Arrays.copyOfRange(nums,i+1,nums.length);
            max = Math.max(max,dp(nums_temp,max)+nums[i]);
        }
        return max;
    }
}
