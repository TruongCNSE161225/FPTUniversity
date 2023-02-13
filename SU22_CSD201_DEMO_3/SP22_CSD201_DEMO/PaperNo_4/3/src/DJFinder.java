import java.util.ArrayList;
import java.util.Collections;

public class DJFinder {

    public static final int INF = 99;
    Graph graph;
    int startV = -1;
    boolean[] flags;
    int[] costs;
    int[] predecessors;
    int nVertices;
    boolean finished = false;

    public DJFinder(Graph graph) {
        this.graph = graph;
        this.nVertices = graph.n;
        this.flags = new boolean[nVertices];
        this.costs = new int[nVertices];
        this.predecessors = new int[nVertices];
    }

    private void prepare(int startV) {
        for (int i = 0; i < this.nVertices; i++) {
            this.flags[i] = false;
            this.costs[i] = INF;
            predecessors[i] = -1;
        }
        this.flags[startV] = true;
        this.costs[startV] = 0;
        this.finished = false;
    }

    private int getMinCostVertex() {
        int minVertex = -1;
        for (int i = 0; i < this.nVertices; i++) {
            if (!flags[i]) {
                if (minVertex == -1) {
                    minVertex = i;
                } else if (this.costs[i] < this.costs[minVertex]) {
                    minVertex = i;
                }
            }
        }
        return minVertex;
    }

    public void DJ(int startV) {
        this.startV = startV;
        this.finished = false;
        prepare(startV);
        int v = startV;
        int newCostToU, weightVU;
        while (v != -1) {
            flags[v] = true;
            for (int u = 0; u < this.nVertices; u++) {
                weightVU = this.graph.a[v][u];
                if (weightVU < INF && !flags[u]) {
                    newCostToU = costs[v] + weightVU;
                    if (newCostToU < costs[u]) {
                        costs[u] = newCostToU;
                        predecessors[u] = v;
                    }
                }
            }
            v = getMinCostVertex();
        }
        this.finished = true;
    }

    public ArrayList getShortestPath(int u) {
        ArrayList<String> path = new ArrayList();
        int dest = u;
        int src = predecessors[dest];
        while (src != -1) {
            path.add(graph.v[dest] + "");
            dest = src;
            src = predecessors[dest];
        }
        path.add(graph.v[startV] + "");
        Collections.reverse(path);
        return path;
    }
}
