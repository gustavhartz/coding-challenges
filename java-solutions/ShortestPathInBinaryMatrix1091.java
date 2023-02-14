import java.util.*;

class ShortestPathInBinaryMatrix1091 {
    /*
     * We can solve this problem using a BFS approach where we just allow for
     * walking in the 8-directional way from
     */
    private int n;

    public int shortestPathBinaryMatrix(int[][] grid) {

        this.n = grid.length;

        // If start is equal to one or only a single grid
        if (n == 1 || grid[0][0] == 1) {
            return grid[0][0] == 0 ? 1 : -1;
        }
        // BFS
        HashMap<Integer, Integer> distances = new HashMap<>();
        Queue<Integer> que = new LinkedList<Integer>();
        Set<Integer> seen = new HashSet<Integer>();

        que.add(0);
        distances.put(0, 1);
        seen.add(0);
        while (!que.isEmpty()) {
            int node = que.poll();

            // get neighbours
            List<List<Integer>> cand = getAdjacent(node / this.n, node % this.n);

            for (List<Integer> c : cand) {
                int cur_node = c.get(0) * this.n + c.get(1);
                int node_i = cur_node / this.n;
                int node_j = cur_node % this.n;
                if ((!distances.containsKey(cur_node)) && (grid[node_i][node_j] != 1) && (!seen.contains(cur_node))) {
                    distances.put(cur_node, distances.get(node) + 1);
                    que.offer(cur_node);
                    seen.add(cur_node);
                }
            }
        }
        return distances.getOrDefault(n * n - 1, -1);

    }

    private boolean isValidPos(int i, int j, int n) {
        if (i < 0 || j < 0 || i > n - 1 || j > n - 1) {
            return false;
        }
        return true;
    }

    // Function that returns all adjacent elements
    private List<List<Integer>> getAdjacent(int i, int j) {
        // Initialising a array list where adjacent element
        // will be stored
        List<List<Integer>> v = new ArrayList<>();

        // Checking for all the possible adjacent positions
        if (isValidPos(i - 1, j - 1, n)) {
            v.add(Arrays.asList(i - 1, j - 1));
        }
        if (isValidPos(i - 1, j, n)) {
            v.add(Arrays.asList(i - 1, j));
        }
        if (isValidPos(i - 1, j + 1, n)) {
            v.add(Arrays.asList(i - 1, j + 1));
        }
        if (isValidPos(i, j - 1, n)) {
            v.add(Arrays.asList(i, j - 1));
        }
        if (isValidPos(i, j + 1, n)) {
            v.add(Arrays.asList(i, j + 1));

        }
        if (isValidPos(i + 1, j - 1, n)) {
            v.add(Arrays.asList(i + 1, j - 1));

        }
        if (isValidPos(i + 1, j, n)) {
            v.add(Arrays.asList(i + 1, j));

        }
        if (isValidPos(i + 1, j + 1, n)) {
            v.add(Arrays.asList(i + 1, j + 1));

        }
        // Returning the arraylist
        return v;
    }

    public static void main(String[] args) {
        ShortestPathInBinaryMatrix1091 sol = new ShortestPathInBinaryMatrix1091();
        int[][] graph = { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 } };
        System.out.println(sol.shortestPathBinaryMatrix(graph));
        int[][] graph2 = { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 1 } };
        System.out.println(sol.shortestPathBinaryMatrix(graph2));
        int[][] graph3 = { { 0 } };
        System.out.println(sol.shortestPathBinaryMatrix(graph3));
        int[][] graph4 = { { 1 } };
        System.out.println(sol.shortestPathBinaryMatrix(graph4));
        int[][] graph5 = { { 0, 1 }, { 1, 0 } };
        System.out.println(sol.shortestPathBinaryMatrix(graph5));
        int[][] graph6 = { { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0 }, { 0, 0, 1, 0, 1, 0, 1, 1 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 1, 1, 0, 0 }, { 1, 0, 1, 1, 1, 0, 0, 0 } };
        System.out.println(sol.shortestPathBinaryMatrix(graph6));

    }
}