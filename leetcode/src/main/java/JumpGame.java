public class JumpGame {

    public static void main(String[] args) {
        int[] nums={2,0};
        System.out.println(jumpgame(nums));
    }

    public static boolean jumpgame(int[] nums){
        int pos = 0;
        while (pos<nums.length){
            if(pos>=nums.length-1)
                return true;
            if(nums[pos]==0)
                return false;
            int temp = 0;
            int pos_temp = pos;
            for (int i = 1; i <= nums[pos_temp]&&(i+pos_temp)<nums.length; i++) {
                if(i+nums[i+pos_temp]>=temp){
                    temp = i+nums[i+pos_temp];
                    pos = i+pos_temp;
                }
            }
        }
        return false;
    }
}
