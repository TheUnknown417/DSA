import java.util.*;

// Edge class to represent edges in the graph
class Edge {
    int source;
    int dest;
    int cost;

    public Edge(int source, int dest, int cost) {
        this.source = source;
        this.dest = dest;
        this.cost = cost;
    }
}

// Pair class for PriorityQueue
class Pair implements Comparable<Pair> {
    int node;
    int cost;

    public Pair(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Pair other) {
        return this.cost - other.cost;
    }
}

// AdjacencyList class to represent the graph
class AdjacencyList {
    ArrayList<Edge>[] graph;
    Map<Character, Integer> vertexToIndex;
    Map<Integer, Character> indexToVertex;
    int vertices;

    @SuppressWarnings("unchecked")
    public AdjacencyList(char[] vertexNames) {
        this.vertices = vertexNames.length;
        this.graph = new ArrayList[vertices];
        this.vertexToIndex = new HashMap<>();
        this.indexToVertex = new HashMap<>();

        // Initialize mappings and adjacency lists
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
            vertexToIndex.put(vertexNames[i], i);
            indexToVertex.put(i, vertexNames[i]);
        }
    }

    // Method to add an edge to the graph
    public void addEdge(char source, char dest, int cost) {
        int srcIndex = vertexToIndex.get(source);
        int destIndex = vertexToIndex.get(dest);

        graph[srcIndex].add(new Edge(srcIndex, destIndex, cost));
        graph[destIndex].add(new Edge(destIndex, srcIndex, cost)); // Undirected graph
    }
}

// PrimsAlgorithm class to implement Prim's Algorithm
class PrimsAlgorithm {
    public void primsMST(ArrayList<Edge>[] graph, int vertices, Map<Integer, Character> indexToVertex) {
        PriorityQueue<Pair> PQ = new PriorityQueue<>();
        boolean[] visited = new boolean[vertices];
        int MSTcost = 0;
        List<String> MSTedges = new ArrayList<>();
        int[] parent = new int[vertices]; // To store the MST parent

        Arrays.fill(parent, -1); // Initialize parent array with -1

        PQ.add(new Pair(0, 0)); // Start with the first node (index 0)

        while (!PQ.isEmpty()) {
            Pair current = PQ.poll();

            if (visited[current.node]) continue;

            visited[current.node] = true; // Mark the node as visited
            MSTcost += current.cost; // Add the cost to MST

            if (parent[current.node] != -1) {
                // Add the edge to MSTedges only if it forms the MST
                MSTedges.add(indexToVertex.get(parent[current.node]) + " -> " + indexToVertex.get(current.node) + " : " + current.cost);
            }

            // Explore all neighbors of the current node
            for (Edge edge : graph[current.node]) {
                if (!visited[edge.dest]) {
                    PQ.add(new Pair(edge.dest, edge.cost));
                    parent[edge.dest] = current.node; // Update the parent for the destination node
                }
            }
        }

        printMST(MSTcost, MSTedges);
    }

    // Function to print the MST cost and edges
    private void printMST(int cost, List<String> edges) {
        System.out.println("Total cost of Minimum Spanning Tree (MST): " + cost);
        System.out.println("Edges in MST:");
        for (String edge : edges) {
            System.out.println(edge);
        }
    }
}

// Main class to execute the program
public class Main {
    public static void main(String[] args) {
        char[] vertexNames = {'A', 'B', 'C', 'D', 'E', 'F', 'G'}; // Vertices represented as characters
        AdjacencyList adjacencyList = new AdjacencyList(vertexNames);

        // Add edges to the graph
        adjacencyList.addEdge('A', 'B', 2);
        adjacencyList.addEdge('A', 'D', 6);
        adjacencyList.addEdge('B', 'C', 3);
        adjacencyList.addEdge('B', 'D', 8);
        adjacencyList.addEdge('B', 'E', 5);
        adjacencyList.addEdge('C', 'E', 7);

        // Apply Prim's Algorithm
        PrimsAlgorithm mst = new PrimsAlgorithm();
        mst.primsMST(adjacencyList.graph, vertexNames.length, adjacencyList.indexToVertex);
    }
}
