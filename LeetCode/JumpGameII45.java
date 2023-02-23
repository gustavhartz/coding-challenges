import java.util.Arrays;

public class JumpGameII45 {
    // Simple linear space time in n solution
    // Can be done in constant space

    public int jump(int[] nums) {
        int n = nums.length;
        int[] distance = new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[0]=0;

        for (int i=0;i<n;i++){
            int jump = nums[i];
            int dist = distance[i];
            for(int j=i;j<=i+jump;j++){
                if(j>=n){
                    break;
                }
                if(distance[j]>dist+1){
                    distance[j]=dist+1;
                }
            }
        }
        return distance[n-1];
    }

    public static void main(String[] args) {
        int[] nums = {2,3,0,1,4};
        JumpGameII45 sol = new JumpGameII45();
        System.out.println(sol.jump(nums));
    }
}
