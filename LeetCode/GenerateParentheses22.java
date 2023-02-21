import java.util.ArrayList;
import java.util.List;
// Crazy easy once you get the idea
// Took 5 minutes - not really a medium question
public class GenerateParentheses22 {
    List<String> output = new ArrayList<>();
    int n;
    public List<String> generateParenthesis(int n) {
        this.n=n;
        helper(0,n,"");
        return output;
    }

    private void helper(int open, int remaining, String cur){
        if (cur.length()==n*2){
            output.add(cur);
            return;
        }
        // Spawn opening
        if(remaining>0){
            helper(open+1, remaining-1,cur+"(");
        }
        // Spawn closing
        if(open>0){
            helper(open-1,remaining,cur+")");
        }

    }

    public static void main(String[] args) {
        GenerateParentheses22 sol = new GenerateParentheses22();
        int n=8;
        System.out.println(sol.generateParenthesis(n));
    }


}
