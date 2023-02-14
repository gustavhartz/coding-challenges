import java.util.*;

class SurroundedRegions130 {

    private int getIdFromCoord(int i, int j) {
        return this.m * i + j;
    }

    private int[] getCoordinateFromId(int node) {
        int[] test = { node / this.m, node % this.m };
        return test;

    }

    private int m;
    private int n;

    public void solve(char[][] board) {
        // We will solve this one using BFS
        // We need to keep track of what is seen totally and what we have seen during
        // this latest initialized BFS
        // When we start a BFS and discover a connection to a field that is connected to
        // the edges. We don't flip any values seen in this iteration. If not we do

        // extract values
        this.m = board.length;
        this.n = board[0].length;
        // init

        // if n or m less than or equal to two there cannot be a 4-directional
        // sourrounding
        if (m < 3 || n < 3) {
            return;
        }

        //
        Set<Integer> seen = new HashSet<Integer>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Nothing to do
                int nodeId = getIdFromCoord(i, j);
                if (board[i][j] == 'X') {
                    seen.add(nodeId);
                    continue;
                }
                if (seen.contains(nodeId)) {
                    continue;
                }
                // we start a BFS
                Queue<Integer> queue = new LinkedList<Integer>();
                Boolean notSourrounded = false;
                Set<Integer> tooFlood = new HashSet<Integer>();
                queue.add(nodeId);
                seen.add(nodeId);
                tooFlood.add(nodeId);
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    // 4 coordinates are either connected to O, X or edge
                    int[] coord = getCoordinateFromId(node);
                    int[][] potential = { { coord[0] - 1, coord[1] }, { coord[0] + 1, coord[1] },
                            { coord[0], coord[1] - 1 }, { coord[0], coord[1] + 1 } };

                    // iterate coords
                    for (int[] curCoord : potential) {
                        int coord1 = curCoord[0];
                        int coord2 = curCoord[1];
                        int curNode = getIdFromCoord(coord1, coord2);

                        // This island borders the edge
                        if (coord1 < 0 || coord1 >= m || coord2 < 0 || coord2 >= n) {
                            notSourrounded = true;
                        } else if (seen.contains(curNode)) {
                            continue;
                        } else if (board[coord1][coord2] == 'O') {
                            queue.offer(curNode);
                            seen.add(curNode);
                            tooFlood.add(curNode);
                        } else {
                            seen.add(curNode);
                        }
                    }

                }
                if (!notSourrounded) {
                    Iterator<Integer> itr = tooFlood.iterator();
                    while (itr.hasNext()) {
                        int node = itr.next();
                        int[] coord = getCoordinateFromId(node);
                        int coord1 = coord[0];
                        int coord2 = coord[1];
                        board[coord1][coord2] = 'X';
                    }
                }

            }

        }

    }

    public static void main(String[] args) {
        SurroundedRegions130 sol = new SurroundedRegions130();
        char[][] graph = { { 'X', 'O', 'X', 'O', 'X', 'O' }, { 'O', 'X', 'O', 'X', 'O', 'X' },
                { 'X', 'O', 'X', 'O', 'X', 'O' }, { 'O', 'X', 'O', 'X', 'O', 'X' } };
        for (char[] row : graph) {
            System.out.println(row);
        }
        System.out.println("_________");
        sol.solve(graph);
        for (char[] row : graph) {
            System.out.println(row);
        }

    }

}
