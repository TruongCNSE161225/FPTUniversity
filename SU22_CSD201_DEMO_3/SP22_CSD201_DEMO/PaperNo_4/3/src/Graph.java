/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)============================================
import java.io.*;
import java.util.*;
//-------------------------------------------------------------------------------

public class Graph {

    int[][] a;
    int n;
    char v[];
    int deg[];

    Graph() {
        v = "ABCDEFGHIJKLMNOP".toCharArray();
        deg = new int[20];
        a = new int[20][20];
        n = 0;
    }

    void loadData(int k) {  //do not edit this function
        RandomAccessFile f;
        int i, j, x;
        String s;
        StringTokenizer t;
        a = new int[20][20];
        try {
            f = new RandomAccessFile("data.txt", "r");
            for (i = 0; i < k; i++) {
                f.readLine();
            }
            s = f.readLine();
            s = s.trim();
            n = Integer.parseInt(s);
            for (i = 0; i < n; i++) {
                s = f.readLine();
                s = s.trim();
                t = new StringTokenizer(s);
                for (j = 0; j < n; j++) {
                    x = Integer.parseInt(t.nextToken().trim());
                    a[i][j] = x;
                }
            }
            f.close();
        } catch (Exception e) {
        }

    }

    void dispAdj() {
        int i, j;
        for (i = 0; i < n; i++) {
            System.out.println();
            for (j = 0; j < n; j++) {
                System.out.printf("%4d", a[i][j]);
            }
        }
    }

    void fvisit(int i, RandomAccessFile f) throws Exception {
        f.writeBytes("  " + v[i]);
    }

    void fdispAdj(RandomAccessFile f) throws Exception {
        int i, j;
        f.writeBytes("n = " + n + "\r\n");
        for (i = 0; i < n; i++) {
            f.writeBytes("\r\n");
            for (j = 0; j < n; j++) {
                f.writeBytes("  " + a[i][j]);
            }
        }
        f.writeBytes("\r\n");
    }

    void breadth(boolean[] en, int i, RandomAccessFile f) throws Exception {
        Queue q = new Queue();
        int r, j;
        q.enqueue(i);
        en[i] = true;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisit(r, f);
            for (j = 0; j < n; j++) {
                if (!en[j] && a[r][j] > 0) {
                    q.enqueue(j);
                    en[j] = true;
                }
            }
        }
    }

    void breadth(int k, RandomAccessFile f) throws Exception {
        boolean[] en = new boolean[20];
        int i;
        for (i = 0; i < n; i++) {
            en[i] = false;
        }
        breadth(en, k, f);
        for (i = 0; i < n; i++) {
            if (!en[i]) {
                breadth(en, i, f);
            }
        }
    }

    void depth(boolean[] visited, int k, RandomAccessFile f) throws Exception {
        fvisit(k, f);
        visited[k] = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && a[k][i] > 0) {
                depth(visited, i, f);
            }
        }
    }

    void depth(int k, RandomAccessFile f) throws Exception {
        boolean[] visited = new boolean[20];
        int i;
        for (i = 0; i < n; i++) {
            visited[i] = false;
        }
        depth(visited, k, f);
        for (i = 0; i < n; i++) {
            if (!visited[i]) {
                depth(visited, i, f);
            }
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    void depth1(boolean[] visited, int k, RandomAccessFile f, ArrayList resultList) throws Exception {
        resultList.add(k);
        visited[k] = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && a[k][i] > 0) {
                depth1(visited, i, f, resultList);
            }
        }
    }

    void depth1(int k, RandomAccessFile f) throws Exception {
        boolean[] visited = new boolean[20];
        int i;
        //create adjMatrix
        for (i = 0; i < n; i++) {
            visited[i] = false;
        }
        //processing traverling
        ArrayList<Integer> resultList = new ArrayList();
        depth1(visited, k, f, resultList);
        for (i = 0; i < n; i++) {
            if (!visited[i]) {
                depth1(visited, i, f, resultList);
            }
        }
        // control out put 
        int startIndex = 1; //need edit 
        int step = 5;
        for (int j = 0; j < resultList.size(); j++) {
            if (j >= startIndex && j < startIndex + step) {
                int r = resultList.get(j).intValue();
                fvisit(r, f);
            }
        }
    }

    void f1() throws Exception {
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        depth(0, f);
        f.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        depth1(0, f);
        //-------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

//=================================================================
    
    void fvisit2(String result, RandomAccessFile f) throws Exception {
        f.writeBytes("  " + result);
    }

    static final int INF = 99;

    String getShortestPath(Graph g, int startV, int endV) {
        String result = "";
        DJFinder DJF = new DJFinder(g);
        DJF.DJ(startV);
        ArrayList<String> path = DJF.getShortestPath(endV);
        for (String string : path) {
            result += string + " ";
        }
        return result.trim();
    }

    void dijikstra(ArrayList<Integer> setS, ArrayList<Integer> path, int startV, int endV) {

        boolean[] flags = new boolean[n];
        int[] costs = new int[n];
        int[] predecessors = new int[n];

        for (int i = 0; i < n; i++) {
            flags[i] = false;
            costs[i] = a[startV][i];
            predecessors[i] = startV;
        }

        flags[startV] = true;

        int cheapestCost;
        int cheapestNode;
        
        while (true) {
            cheapestCost = INF;
            cheapestNode = -1;

            for (int i = 0; i < n; i++) {
                if (!flags[i]) {
                    if (costs[i] < cheapestCost) {
                        cheapestCost = costs[i];
                        cheapestNode = i;
                    }
                }
            }

            if (cheapestNode == -1) {
                return;
            }
            flags[cheapestNode] = true;
            setS.add(cheapestNode);
            if (cheapestNode == endV) {
                break;
            }

            for (int i = 0; i < n; i++) {
                if (!flags[i]) {
                    if (costs[i] > costs[cheapestNode] + a[cheapestNode][i]) {
                        costs[i] = costs[cheapestNode] + a[cheapestNode][i];
                        predecessors[i] = cheapestNode;
                    }
                }
            }
        }
        
        Stack stack = new Stack();
        int i = endV;
        while (true) {
            stack.push(i);
            if (i == startV) {
                break;
            }
            i = predecessors[i];
        }
        
        while (!stack.isEmpty()) {
            i = stack.pop();
            path.add(i);
        }
    }
    
    void f2() throws Exception {
        loadData(13);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        f.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        // You can use the statement fvisit(i,f); i = 0, 1, 2,...,n-1 to display the vertex i to file f2.txt 
        //  and statement f.writeBytes(" " + k); to write  variable k to the file f2.txt  
        ArrayList<Integer> path1 = new ArrayList<>();
        ArrayList<Integer> setS1 = new ArrayList<>();
        ArrayList<Integer> path2 = new ArrayList<>();
        ArrayList<Integer> setS2 = new ArrayList<>();
        
        dijikstra(setS2, path2, 0, 6);
        dijikstra(setS1, path1, 2, 5);
        
        //path2
        for (Integer integer : path2) {
            fvisit(integer, f);
        }
        f.writeBytes("\r\n");
        //4 last of S
        for (int i = setS2.size() - 4; i < setS2.size(); i++) {
            fvisit(setS2.get(i), f);
        }
        f.writeBytes("\r\n");
        //path 1
        for (Integer integer : path1) {
            fvisit(integer, f);
        }
        //-------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

}
