import java.util.Arrays;
// Very simple alteration to the HouseRobber Code
// 5 minutes to implement
// Solutions found on LC is pretty much the same, but just written more compact
public class HouseRobberII213 {
    public int rob(int[] nums){
        if (nums.length<=3){
            return Arrays.stream(nums).max().getAsInt();
        }

        int[] numsNoEnd = Arrays.stream(nums, 0, nums.length-1).toArray();
        int[] numsNoBegin = Arrays.stream(nums, 1, nums.length).toArray();
        return Math.max(robHelper(numsNoBegin),robHelper(numsNoEnd));


    }
    public int robHelper(int[] nums){
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
        int [] nums = {1,2,3};
        HouseRobberII213 sol = new HouseRobberII213();
        System.out.println(sol.rob(nums));

    }


}
