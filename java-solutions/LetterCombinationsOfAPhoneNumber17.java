import java.util.*;
// LeetCode question
// Pretty easy took around 25 minutes - a lot of time to build the lookup table
public class LetterCombinationsOfAPhoneNumber17 {
    List<String> output = new ArrayList<>();
    String digits;
    Map<Character, char[]> lookup = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        if (digits==null || digits.length()==0){
            return output;
        }
        this.digits=digits;

        for(char c : digits.toCharArray()){
            if (c=='2'){
                lookup.put(c,new char[] {'a','b','c'});
            } else if (c=='3') {
                lookup.put(c,new char[] {'d','e','f'});

            } else if (c=='4') {
                lookup.put(c,new char[] {'g','h','i'});

            } else if (c=='5') {
                lookup.put(c,new char[] {'j','k','l'});
            } else if (c=='6') {
                lookup.put(c,new char[] {'m','n','o'});
            } else if (c=='7') {
                lookup.put(c,new char[] {'p','q','r', 's'});
            } else if (c=='8') {
                lookup.put(c,new char[] {'t','u','v'});
            } else {
                //9
                lookup.put(c,new char[] {'w','x','y','z'});
            }
        }
        helper(0,"");
        return output;

    }

    private void helper(int idx, String cur){
        if (idx==digits.length()){
            output.add(cur);
            return;
        }
        for(char letter : lookup.get(digits.charAt(idx))){
            String temp = cur;
            temp = temp+letter;
            helper(idx+1, temp);
        }

    }

    public static void main(String[] args) {
        String digits = "23";
        LetterCombinationsOfAPhoneNumber17 sol = new LetterCombinationsOfAPhoneNumber17();
        System.out.println(sol.letterCombinations(digits));
    }


}
