import java.util.Arrays;

public class JumpGame55 {
    // Super easy
    // Can do it in constant space by keeping a single int denoting max jumps distance seen so far
    // then do linear pass and update accordingly
    public boolean canJump(int[] nums) {
        int n=nums.length;
        boolean[] res = new boolean[n];
        res[0]=true;

        for (int i=0;i<n;i++){
            if(!res[i]){
                return false;
            }
            int jump =nums[i];
            int j=i;
            while (j<=i+jump && j<n){
                j++;
            }
        }
        return true;

    }

    public boolean canJump2(int[] nums) {
        int n=nums.length;
        int jumpMax = 1;

        for (int i=0;i<n;i++){
            if (i<jumpMax){
                jumpMax=Math.max(jumpMax,jumpMax+nums[i]+1);
            }else{
                return false;
            }
        }
        return jumpMax>=n? true :false;

    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        JumpGame55 sol = new JumpGame55();
        System.out.println(sol.canJump2(nums));
    }
}
