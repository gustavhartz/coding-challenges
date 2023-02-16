import java.util.HashSet;
import java.util.Set;

public class WordSearch79 {
    /*
    This can be solved as a simple DFS problem where we are only allowed to move onto a specific node each time
    running time O(n*m*len(word)). Don't think it's a tight bound.

    This solution is too slow to complete on LeetCode, but the logic is the same as the solution.
    The difference is than once can optimize the solution. Flip the word if in the case of "aaaaaab"
    Check if there could even exist a solution - word count etc.

     */
    int m;
    int n;

    int wordLength;
    char[][] board;
    String word;

    boolean seen=false;
    public boolean exist(char[][] board, String word) {
        m=board.length;
        n=board[0].length;
        wordLength=word.length();
        this.board=board;
        this.word=word;
        for (int i=0; i<m;i++){
            for (int j=0; j<n;j++){
                int id=locationToId(i,j);
                dfsHelper(0,id, i, j);
            }
        }
        return seen;
    }

    private void dfsHelper(int idx, int id, int i, int j){
        if (i<0 || j<0 || i>=m || j>=n ||(board[i][j]!=word.charAt(idx))){
            return;
        }
        board[i][j]='*';
        // Done
        if (idx==wordLength-1){
            seen=true;
            return;
        }
        // visit neighbours
        dfsHelper(idx+1, locationToId(i+1,j), i+1, j);
        dfsHelper(idx+1, locationToId(i-1,j), i-1, j);
        dfsHelper(idx+1, locationToId(i,j+1), i, j+1);
        dfsHelper(idx+1, locationToId(i,j-1), i, j-1);
    }

    private int locationToId(int i, int j ){
        return i*n+j;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "EECS";
        WordSearch79 sol = new WordSearch79();
        System.out.println(sol.exist(board, word));

    }


}
