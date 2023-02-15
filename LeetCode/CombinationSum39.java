import java.util.ArrayList;
import java.util.List;

// LeetCode
public class CombinationSum39 {

    List<List<Integer>> output = new ArrayList<>();
    int[] candidates;
    int target;
    int n;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.target = target;
        this.candidates = candidates;
        this.n = candidates.length;

        helper(0, new ArrayList<Integer>(), 0);
        return output;
    }

    public void helper(int startIdx, ArrayList<Integer> curSolution, int curSum) {
        if (curSum == target) {
            output.add(curSolution);
        }
        // iterate
        for (int i = startIdx; i < n; i++) {
            int cur = candidates[i];
            if (cur + curSum <= target) {
                curSolution.add(cur);
                helper(i, (ArrayList<Integer>) curSolution.clone(), curSum + cur);
                curSolution.remove(curSolution.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = { 1, 2, 3, 6, 7 };
        int target = 7;
        CombinationSum39 sol = new CombinationSum39();
        System.out.println(sol.combinationSum(candidates, target));
    }

}
