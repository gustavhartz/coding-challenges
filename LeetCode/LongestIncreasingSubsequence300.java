import java.util.ArrayList;
import java.util.Arrays;

public class LongestIncreasingSubsequence300 {
    public int lengthOfLIS(int[] nums) {
        return lengthOfLISDS(nums);

    }
    public int lengthOfLISDS(int[] nums) {
        // Simple Dynamic programming solution
        int n = nums.length;
        int [] sol = new int[n];

        for (int i=0;i<n;i++){
            sol[i]=1;
            for (int j=0;j<i;j++){
                if (nums[i]>nums[j] && sol[i]<sol[j]+1){
                    sol[i]=sol[j]+1;
                }
            }
        }
        return Arrays.stream(sol).max().getAsInt();
    }

    public int lengthOfLISGreedy(int[] nums) throws UnsupportedOperationException {
        ArrayList<Integer> sol = new ArrayList<Integer>();

        boolean first =true;
        int head;
        for (int num : nums){
            if (!first){
                head = sol.get(sol.size()-1);
            }else{
                head =(int)-Math.pow(10,4);
            }
            if (num < head){
                sol.add(num);
            }else{
                // Bisect left and replace the element with the current one found
                throw new UnsupportedOperationException();
            }
        }
        return sol.size();

    }
}
