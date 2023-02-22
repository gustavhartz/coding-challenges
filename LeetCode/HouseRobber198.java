import java.util.Arrays;
public class HouseRobber198 {
    public int rob(int[] nums){
        int[] p = new int[nums.length];
        Arrays.fill(p, 0, nums.length-1, 0);

        if (nums.length<=2){
            return Arrays.stream(nums).boxed().max(Integer::compare).get();

        } else if (nums.length==3) {
            return Math.max(nums[0]+nums[2],nums[1]);
        }
        // Fill first part
        p[0]=nums[0];
        p[1]=Math.max(nums[0],nums[1]);
        p[2]=Math.max(nums[0]+nums[2],nums[1]);

        for(int i=3;i<nums.length;i++){
            p[i]=Math.max(p[i-2]+nums[i],p[i-1]);
        }
        return p[nums.length-1];

    }

    public static void main(String[] args) {
        int [] nums = {2,2,5,4,6,7};
        HouseRobber198 sol = new HouseRobber198();
        System.out.println(sol.rob(nums));

    }


}
