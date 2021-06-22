import com.sun.source.doctree.SummaryTree;

public class JumpGame2 {

    public static void main(String[] args) {
        int[] nums={2,0};
        System.out.println(jumpgame2(nums));
    }

    public static int jumpgame2(int[] nums){
        int pos = 0;
        int count = 0;
        while(pos<nums.length-1){
            if(pos+nums[pos]>=nums.length-1) return ++count;
            int temp = 0;
            int pos_temp = pos;
            for (int i = 1; i <= nums[pos_temp]; i++) {
                if(nums[i+pos_temp]+i>=temp){
                    temp = nums[i+pos_temp]+i;
                    pos = i+pos_temp;
                }
            }
            count++;
        }
        return count;
    }
}
