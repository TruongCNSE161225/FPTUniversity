
public class DLL_FlowerList {
    
    DLL_Node head;
    DLL_Node tail;
    
    public DLL_FlowerList() {
        head = tail = null;
    }
    
    public boolean Empty() {
        return head == null;
    }
    
    public boolean addFirst(Flower f) {
        DLL_Node newNode = new DLL_Node(f);
        if (this.Empty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            newNode.previous = null;
            head.previous = newNode;
            head = newNode;
        }
        return true;
    }
    
    public boolean addFirst(String name, String original, int price) {
        Flower f = new Flower(name, original, price);
        return addFirst(f);
    }
    
    public boolean addLast(Flower f) {
        DLL_Node newNode = new DLL_Node(f);
        if (this.Empty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.next = null;
            newNode.previous = tail;
            tail = newNode;
        }
        return true;
    }
    
    public boolean addLast(String name, String original, int price) {
        Flower f = new Flower(name, original, price);
        return addLast(f);
    }
    
    public boolean addbefore(DLL_Node p, Flower f) {
        if (this.Empty() || p == head) {
            return addFirst(f);
        } else {
            DLL_Node newNode = new DLL_Node(f);
            DLL_Node before = p.previous;
            before.next = newNode;
            newNode.next = p;
            p.previous = newNode;
            newNode.previous = before;
        }
        return true;
    }
    
    public boolean addAfter(DLL_Node p, Flower f) {
        if (this.Empty() || p == tail) {
            return addLast(f);
        } else {
            DLL_Node newNode = new DLL_Node(f);
            DLL_Node after = p.next;
            p.next = newNode;
            newNode.next = after;
            after.previous = newNode;
            newNode.previous = p;
        }
        return true;
    }
    
    public DLL_Node search(String flowerName) {
        if (this.Empty()) {
            return null;
        }
        Flower f = new Flower(flowerName);
        DLL_Node p = head;
        while (p != null) {
            if (p.flower.equals(f)) {
                return p;
            } else {
                p = p.next;
            }
        }
        return null;
    }
    
    public DLL_Node removeFirst() {
        if (this.Empty()) {
            return null;
        }
        DLL_Node result = head;
        if (head == tail) {
            head = tail = null;
        } else {
            DLL_Node newHead = head.next;
            newHead.previous = null;
            head = newHead;
        }
        return result;
    }
    
    public DLL_Node removeLast() {
        if (this.Empty()) {
            return null;
        }
        DLL_Node result = tail;
        if (head == tail) {
            head = tail = null;
        } else {
            DLL_Node newTail = tail.previous;
            newTail.next = null;
            tail = newTail;
        }
        return result;
    }
    
    public DLL_Node remove(DLL_Node p) {
        if (this.Empty() || p == null) {
            return null;
        }
        if (p == head) {
            return removeFirst();
        }
        if (p == tail) {
            return removeLast();
        }
        DLL_Node before = p.previous;
        DLL_Node after = p.next;
        before.next = after;
        after.previous = before;
        return p;
    }
    
    public Flower remove(String flowerName) {
        DLL_Node p = this.search(flowerName);
        DLL_Node removedNode = remove(p);
        return (removedNode != null) ? removedNode.flower : null;
    }
    
    public void printAll() {
        if (this.Empty()) {
            System.out.println("Empty list!");
        } else {
            for (DLL_Node p = head; p != null; p = p.next) {
                System.out.println(p.flower);
            }
        }
    }
    
    public void printAll_reverse() {
        if (this.Empty()) {
            System.out.println("Empty list!");
        } else {
            for (DLL_Node p = tail; p != null; p = p.previous) {
                System.out.println(p.flower);
            }
        }
    }

    public void printAll_Org(String original) {
        if (this.Empty()) {
            System.out.println("Empty list!");
        } else {
            for (DLL_Node p = head; p != null; p = p.next) {
                if (p.flower.original.equals(original)) {
                    System.out.println(p.flower);
                }
            }
        }
    }
}
