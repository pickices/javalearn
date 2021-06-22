import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        int[] candidates={10,1,2,7,6,1,5};
        //1,1,2,5,6,7,10
        System.out.println(combinationSum2.function(candidates,8));

    }

    public List<List<Integer>> function(int[] candidates, int target){
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs2(candidates,target,res,new ArrayList<Integer>(),0);
        return res;
    }

    public void dfs2(int[] candidates,int target,List<List<Integer>> res,List<Integer> ans,int i){
        if(target==0){
            res.add(new ArrayList<Integer>(ans));
            return;
        }
        for (int start = i; start < candidates.length; start++) {
            if(target-candidates[start]<0)
                break;
            if(start>i&&candidates[start] == candidates[start-1])
                continue;
            ans.add(candidates[start]);
            dfs2(candidates,target-candidates[start],res,ans,start+1);
            ans.remove(ans.size()-1);
        }
    }
}
