public class LongestPalindromicSubstring5 {
    // N**2 space and time, but getSolution is pretty inefficient due to multiple calls to same fields - exp in size
    public String longestPalindrome(String s) {
        int n=s.length();
        int[][] m = new int[n][n];
        String longest = "" + s.charAt(0);

        // Set diagonal
        for (int i=0;i<n;i++){
            m[i][i]=1;

            // Edgecase in plaindrome of size 2
            if (i>0) {
                m[i][i - 1] = 1;
            }

        }
        // Fill out solution starting from size 2 and then up
        for (int size=1;size<n;size++){
            for(int start =0;start<n-size;start++){
                m[start][start+size]=(s.charAt(start)==s.charAt(start+size) && m[start+1][start+size-1]==1)?1:0;
                if (m[start][start+size]==1&&size>=longest.length()){
                    longest=s.substring(start,start+size+1);

                }
            }
        }
        return longest;

    }

    private String getSolution(int[][] m, String s, int i, int j){
        if (i==j){
            return "" + s.charAt(i);
        }
        if (m[i][j]==1){
            return "" + s.substring(i,j+1);
        }

        String s1 = getSolution(m,s,i+1,j);
        String s2 = getSolution(m,s,i,j-1);
        return (s1.length()>=s2.length())?s1:s2;



    }

    public static void main(String[] args) {
        String s = "a";
        LongestPalindromicSubstring5 sol = new LongestPalindromicSubstring5();
        System.out.println(sol.longestPalindrome(s));
    }
}
