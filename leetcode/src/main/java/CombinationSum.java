import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class CombinationSum {
    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] candidates={2,7,6,3,5,1};
        System.out.println(combinationSum.function(candidates,9));

    }

    public List<List<Integer>> function(int[] candidates, int target){
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates,target,res,new ArrayList<Integer>(),0);
        return res;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> res,ArrayList<Integer> ans,int i){
        if(target==0){
            res.add(new ArrayList<>(ans));
            return;
        }

        for (int start = i; start < candidates.length; start++) {
            if(target-candidates[start]<0) {
                break;
            }
            ans.add(candidates[start]);
            dfs(candidates,target-candidates[start],res,ans,start);
            ans.remove(ans.size()-1);
        }
    }
}
