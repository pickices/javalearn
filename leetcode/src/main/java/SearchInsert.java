public class SearchInsert {
    public static void main(String[] args) {
        int[] nums = {1};
        SearchInsert searchInsert = new SearchInsert();
        System.out.println(searchInsert.function(nums,2));
    }

    public int function(int[] nums,int target){
        int l=0,r=nums.length;
        while (l<r){
            int mid = (l+r)/2;
            if(target==nums[mid])
                return mid;
            if(target<nums[mid]){
                r = mid;
            }
            else{
                l = mid+1;
            }
        }
        return r;
    }
}
