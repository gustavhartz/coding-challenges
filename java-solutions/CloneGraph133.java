import java.util.*;
// LeetCode

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class CloneGraph133 {
    public Node cloneGraph(Node node) {
        // general idea is to run BFS from the start node and create the nodes from
        // there
        // when we reach a node we iterate through all it's neighbours. If the have
        // already been created use a pointer to the create node
        // if not then we create a new node and add it to our node and the lookup table
        // with nodes.

        // Early stopping :)
        if (node == null) {
            return null;
        }

        // Init the resources
        HashSet<Integer> seen = new HashSet<Integer>();
        Queue<Node> queue = new LinkedList<>();
        HashMap<Integer, Node> clonedGraph = new HashMap<>();

        final int rootNodeValue = node.val;

        // We will use a dummy node as th
        ArrayList<Node> dummyN = new ArrayList<Node>();
        dummyN.add(node);
        Node dummy = new Node(-1, dummyN);
        queue.offer(dummy);

        // run bfs
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            Node curClone = getOrCreateNode(clonedGraph, cur.val);
            // create neighbours
            ArrayList<Node> curNeighbors = new ArrayList<>();
            for (Node neighbour : cur.neighbors) {
                Node curNeighbour = getOrCreateNode(clonedGraph, neighbour.val);
                curNeighbors.add(curNeighbour);
                if (!seen.contains(neighbour.val)) {
                    seen.add(neighbour.val);
                    queue.offer(neighbour);
                }
            }
            curClone.neighbors = curNeighbors;

        }
        return clonedGraph.get(rootNodeValue);

    }

    public static Node getOrCreateNode(HashMap<Integer, Node> graph, int val) {
        Node node = graph.getOrDefault(val, null);
        if (node == null) {
            node = new Node(val);
            graph.put(val, node);
        }
        return node;
    }

    public static void main(String[] args) {
        CloneGraph133 sol = new CloneGraph133();
        // graph
        Node head = new Node(1);
        Node headClone = sol.cloneGraph(head);
        if (head == headClone) {
            System.out.print("same");
        }
        {
            System.out.print(String.format("diff %o %o", head.val, headClone.val));
        }

    }
}