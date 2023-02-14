import java.util.*;

public class SubsetsII90 {
    int k;
    int n;
    ArrayList<List<Integer>> sol = new ArrayList<>();
    int[] data;
    Set<List<Integer>> seen = new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums){
        n=nums.length;
        k=0;
        Arrays.sort(nums);
        data=nums;
        while (k<=n){
            helper(new ArrayList<Integer>(), 0);
            k++;
        }
        return sol;
    }
    public void helper(List<Integer> cur, int idx){
        if(cur.size()==k){
            // Copy to avoid it being mutated
            if (!seen.contains(cur)){
                sol.add(new ArrayList<Integer>(cur));
                seen.add(new ArrayList<Integer>(cur));
            }

            return ;
        }
        for( int i=idx; i<n;i++){
            cur.add(data[i]);
            helper(cur, i+1);
            cur.remove(cur.size()-1);


        }

    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3};
        SubsetsII90 sol = new SubsetsII90();
        System.out.println(sol.subsetsWithDup(nums));
    }

}
