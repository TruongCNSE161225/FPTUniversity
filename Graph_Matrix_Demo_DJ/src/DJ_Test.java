
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class DJ_Test {

    public static Graph_Matrix loadGraph(String fName) throws Exception {
        Graph_Matrix g = null;
        FileReader fr = new FileReader(fName);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine().trim();
        g = new Graph_Matrix(line);
        int size = line.length();
        int[][] m = new int[size][size];
        StringTokenizer stk;
        for (int i = 0; i < size; i++) {
            line = br.readLine().trim();
            stk = new StringTokenizer(line, ",");
            for (int j = 0; j < size; j++) {
                String value = stk.nextToken().trim().toUpperCase();
                if (value.equals("INF")) {
                    m[i][j] = DJ_Finder.INF;
                } else {
                    m[i][j] = Integer.parseInt(value);
                }
            }
        }
        br.close();
        fr.close();
        g.setAdjMatrix(m);
        return g;
    }

    public static void main(String[] args) throws Exception {
        String sourceF = "DJgraph01.txt";
        String resultF = "DJgraph01-Results.txt";
        System.out.println("Source file: " + sourceF);
        Graph_Matrix g = loadGraph(sourceF);
        DJ_Finder djFinder = new DJ_Finder(g);
        int startV = 3;
        djFinder.DJ(startV);
        System.out.println("Shortest paths from " + g.vSet[startV] + ":");
        System.out.println(djFinder.spsToString());
        if (djFinder.printSPsToFile(resultF)) {
            System.out.println("File, " + resultF + ", has been written.\n");
        }
    }
}
