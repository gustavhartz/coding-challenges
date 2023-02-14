import java.util.*;

public class PermutationsII47 {
    List<List<Integer>> output=new ArrayList<>();
    int n;
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums ==null){
            output.add(new ArrayList<>());
            return output;
        }
        n= nums.length;

        // Make a counter map that will contain the unique numbers as keys and the number of them as values
        Map<Integer,Integer> availableNumbers = new HashMap<>();
        for (int number: nums){
            if (!availableNumbers.containsKey(number)){
                availableNumbers.put(number,0);
            }
            availableNumbers.put(number,availableNumbers.get(number)+1);
        }
        helper(availableNumbers, new ArrayList<>());
        return output;
    }

    public void helper(Map<Integer,Integer> nums, ArrayList<Integer> cur){
        if (cur.size()==n){
            output.add(cur);
            return;
        }
        // iterate keys and values and recurse
        for (int key : nums.keySet()){
            int occ = nums.get(key);
            // When all are em
            if (occ==0){
                continue;
            }
            cur.add(key);
            nums.put(key,occ-1);
            helper(nums, (ArrayList<Integer>) cur.clone());
            // return to original state
            nums.put(key,occ);
            cur.remove(cur.size()-1);
        }
    }



    public static void main(String[] args) {
        int[] numbers = {1,1,2,2};
        PermutationsII47 sol = new PermutationsII47();
        System.out.println(sol.permuteUnique(numbers));
    }
}
