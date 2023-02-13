
import java.io.File;
import java.io.RandomAccessFile;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SLL_SoftDrink {

    SLL_Node head, tail;

    public SLL_SoftDrink() {
        head = tail = null;
    }

    public boolean Empty() {
        return head == null;
    }

    public void addFirst(SoftDrink aSD) {
        SLL_Node newNode = new SLL_Node(aSD);
        if (this.Empty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void addFirst(String pLine, String company, int volume, int price) {
        addFirst(new SoftDrink(pLine, company, volume, price));
    }

    public void addLast(SoftDrink aSD) {
        SLL_Node newNode = new SLL_Node(aSD);
        if (this.Empty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void addLast(String pLine, String company, int volume, int price) {
        addLast(new SoftDrink(pLine, company, volume, price));
    }

    private SoftDrink createSD(String line) {
        StringTokenizer stk = new StringTokenizer(line, ",");
        String productline = stk.nextToken().trim();
        String company = stk.nextToken().trim();
        int volume = Integer.parseInt(stk.nextToken().trim());
        int price = Integer.parseInt(stk.nextToken().trim());
        return new SoftDrink(productline, company, volume, price);
    }

    public void loadFromFile(String fName) throws Exception {
        FileReader fr = new FileReader(fName);
        BufferedReader bf = new BufferedReader(fr);
        String line;
        StringTokenizer stk;
        for (int i = 0; i < 3; i++) {
            line = bf.readLine();
            this.addFirst(createSD(line));
        }
        while ((line = bf.readLine()) != null) {
            this.addLast(createSD(line));
        }
    }

    public SoftDrink search(String productLine) {
        if (this.Empty()) {
            return null;
        }
        SLL_Node p = head;
        while (p != null) {
            if (p.data.productLine.equals(productLine)) {
                return p.data;
            } else {
                p = p.next;
            }
        }
        return null;
    }

    public void reverse() {
        if (this.Empty()) {
            return;
        }
        SLL_Node after = null, p = head, before = p.next;
        while (p != null) {
            p.next = after;
            after = p;
            p = before;
            if (p != null) {
                before = p.next;
            }
        }
        p = head;
        head = tail;
        tail = p;
    }

    public SoftDrink remove(String pLine) {
        if (this.Empty()) {
            return null;
        }
        SoftDrink aSoftDrink = new SoftDrink(pLine);
        SoftDrink removedEle = null;
        SLL_Node pAfter = null, pDel = head;
        while (pDel != null && !pDel.data.equals(aSoftDrink)) {
            pAfter = pDel;
            pDel = pDel.next;
        }
        if (pDel != null) {
            removedEle = pDel.data;
            if (pDel == head) {
                if (head == tail) {
                    head = tail = null;
                } else {
                    head = head.next;
                }
            } else if (pDel == tail) {
                pAfter.next = null;
                tail = pAfter;
            } else {
                pAfter.next = pDel.next;
            }
        }
        return removedEle;
    }

    private void visit(SLL_Node node) {
        System.out.print(node.data + "\n");
    }

    public void printAll() {
        if (this.Empty()) {
            System.out.println("EMPTY LIST.");
        } else {
            for (SLL_Node p = head; p != null; p = p.next) {
                visit(p);
            }
        }
    }

    public void printCompanyBased(String company) {
        if (this.Empty()) {
            System.out.println("EMPTY LIST.");
        } else {
            for (SLL_Node p = head; p != null; p = p.next) {
                if (p.data.company.equals(company)) {
                    visit(p);
                }
            }
        }
    }

    public void ascSort_Price_then_pLine() {
        if (this.Empty()) {
            return;
        }
        SoftDrink t;
        SLL_Node i, j;
        for (i = head; i != tail; i = i.next) {
            for (j = i.next; j != null; j = j.next) {
                if (j.data.compareTo(i.data) < 0) {
                    t = i.data;
                    i.data = j.data;
                    j.data = t;
                }
            }
        }
    }

    private void visit_binF(RandomAccessFile f, SLL_Node node) throws Exception {
        f.writeBytes(node.data.toString() + "\r\n");

    }

    public void printAll_binF(String filename) throws Exception {
        if (this.Empty()) {
            System.out.println("EMPTY LIST.");
        } else {
            File f = new File(filename);
            if (f.exists()) {
                f.delete();
            }
            RandomAccessFile rf = new RandomAccessFile(f, "rw");
            for (SLL_Node p = head; p != null; p = p.next) {
                visit_binF(rf, p);
            }
            rf.close();
        }
    }

    private void visit_txtF(PrintWriter f, SLL_Node node) throws Exception {
        f.println(node.data);
    }

    public void printAll_txtF(String filename) throws Exception {
        if (this.Empty()) {
            System.out.println("EMPTY LIST.");
        } else {
            PrintWriter pw = new PrintWriter(filename);
            for (SLL_Node p = head; p != null; p = p.next) {
                visit_txtF(pw, p);
            }
            pw.close();
        }
    }
}
