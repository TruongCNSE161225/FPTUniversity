
import java.util.ArrayList;
import java.util.Stack;
import java.io.File;
import java.io.RandomAccessFile;

public class Euler_Graph extends Graph_Matrix {

    ArrayList<Integer> E_Cycle;
    int startV = 0;

    public Euler_Graph() {
        super();
    }

    public Euler_Graph(String vertexNames) {
        super(vertexNames);
    }

    private int degree(int v) {
        int result = 0;
        for (int j = 0; j < nVerticles; j++) {
            result += adjMatrix[v][j];
        }
        return result;
    }

    private int countOddVerticles() {
        int count = 0;
        for (int i = 0; i < nVerticles; i++) {
            if (degree(i) % 2 > 0) {
                count++;
            }
        }
        return count;
    }

    public boolean hasEulerCycle() {
        return countOddVerticles() == 0;
    }

    public boolean hasEulerPath() {
        return countOddVerticles() == 2;
    }

    private int firstAjacent(int v) {
        for (int j = 0; j < nVerticles; j++) {
            if (adjMatrix[v][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    public Euler_Graph copy() {
        Euler_Graph result = new Euler_Graph();
        result.nVerticles = this.nVerticles;
        result.vSet = this.vSet;
        result.setAdjMatrix(this.adjMatrix);
        return result;
    }

    private void removeOneEdge(int u, int v) {
        if (adjMatrix[u][v] > 0) {
            adjMatrix[u][v]--;
            adjMatrix[v][u]--;
        }
    }

    public ArrayList<Integer> findEulerCycle(int startV) {
        if (!hasEulerCycle()) {
            return E_Cycle = null;
        }
        this.startV = startV;
        Euler_Graph gr = this.copy();
        E_Cycle = new ArrayList();
        Stack<Integer> stk = new Stack();
        stk.push(startV);
        int u;
        while (!stk.empty()) {
            u = stk.peek();
            int v = gr.firstAjacent(u);
            if (v >= 0) {
                stk.push(v);
                gr.removeOneEdge(u, v);
            } else {
                E_Cycle.add(stk.pop());
            }
        }
        return E_Cycle;
    }

    public String EulerCycleStr() {
        if (E_Cycle == null) {
            return null;
        }
        String result = "Euler cycle from " + this.vSet[startV] + ": ";
        for (Integer v : E_Cycle) {
            result += this.vSet[v] + " ";
        }
        return result;
    }

    public boolean printEulerCycleToFile(String filename) throws Exception {
        if (E_Cycle == null) {
            return false;
        }
        File f = new File(filename);
        if (f.exists()) {
            f.delete();
        }
        RandomAccessFile rf = new RandomAccessFile(f, "rw");
        rf.writeBytes(this.EulerCycleStr() + "\r\n");
        rf.close();
        return true;
    }
}
