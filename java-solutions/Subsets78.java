import java.util.*;

class Subsets78 {
    // creates n!
    public List<List<Integer>> subsets(int[] nums) {

        // Give it the right shape
        Set<Integer> numberSet = new HashSet<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int element : nums) {
            linkedList.add(element);
        }

        // Results
        Set<Set<Integer>> setsOfSets = subsetsHelper(numberSet, linkedList);
        List<List<Integer>> listOfLists = new ArrayList<>();

        setsOfSets.forEach(set -> listOfLists.add(new ArrayList<>(set)));

        return listOfLists;
    }

    private Set<Set<Integer>> subsetsHelper(Set<Integer> choosen, LinkedList<Integer> available) {
        // return the choosen set including and excluding the next number
        Set<Set<Integer>> toReturn = new HashSet<>();
        toReturn.add(choosen);

        // base case
        if (available.isEmpty()) {
            return toReturn;
        }
        HashSet<Integer> included = new HashSet<Integer>(choosen);
        int nextInt = available.poll();
        included.add(nextInt);
        toReturn.add(included);
        // get the nested elements

        Set<Set<Integer>> subsetExcluded = subsetsHelper(choosen, (LinkedList<Integer>) available.clone());
        Set<Set<Integer>> subsetIncluded = subsetsHelper(included, (LinkedList<Integer>) available.clone());

        toReturn.addAll(subsetExcluded);
        toReturn.addAll(subsetIncluded);
        return toReturn;
    }

    public static void main(String[] args) {
        int[] numbers = {1,1,2};
        Subsets78 sol = new Subsets78();
        System.out.println(sol.subsets(numbers));
    }

}