import java.util.*;

class AllPathsFromSourceToTarget797 {
    private List<List<Integer>> ans;
    private int[][] graph;
    private int n;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // There are no cycles and a node without outgoing edges so we don't need to
        // worry about recursion getting out of hand
        // Run dfs from top. Append solutions to res

        this.graph = graph;
        this.n = graph.length - 1;
        this.ans = new LinkedList();
        List<Integer> path = new ArrayList();
        path.add(0);
        dfs(0, this.n, path);
        return this.ans;
    }

    private void dfs(int src, int goal, List<Integer> path) {
        if (src == goal) {
            this.ans.add(new ArrayList<>(path));
        }
        // add all path from here
        for (int i : this.graph[src]) {
            path.add(i);
            dfs(i, this.n, path);
            // Path exhausted
            path.remove((path.size() - 1));
        }
    }

    public static void main(String[] args) {
        int[][] graph = { { 4, 3, 1 }, { 3, 2, 4 }, { 3 }, { 4 }, {} };
        AllPathsFromSourceToTarget797 sol = new AllPathsFromSourceToTarget797();
        System.out.print(sol.allPathsSourceTarget(graph));

    }
}