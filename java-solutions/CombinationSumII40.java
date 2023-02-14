import java.util.ArrayList;
import java.util.List;
import java.util.*;


public class CombinationSumII40 {

    List<List<Integer>> output = new ArrayList<>();
    int[] candidates;
    int target;
    int n;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.target=target;
        this.candidates=candidates;
        this.n=candidates.length;
        helper(0, new ArrayList<Integer>(), 0);
        return output;
    }

    public void helper(int startIdx, ArrayList<Integer> curSolution, int curSum){
        if (curSum==target){
            output.add(curSolution);
        }
        // iterate
        for (int i=startIdx; i<n; i++){
            if (i!=startIdx && candidates[i]==candidates[i-1]){
                continue;
            }
            int cur = candidates[i];
            if (cur+curSum<=target){
                curSolution.add(cur);
                helper(i+1, (ArrayList<Integer>) curSolution.clone(), curSum+cur);
                curSolution.remove(curSolution.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {1,1,2,2,5,6,7,7,10};
        int target = 8;
        CombinationSumII40 sol = new CombinationSumII40();
        System.out.println(sol.combinationSum2(candidates,target));
    }

}