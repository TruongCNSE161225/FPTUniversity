
class Animal {

    int id;

    public Animal() {
    }

    public Animal(int id) {
        this.id = id;
    }

    
}

public class Test {

    public static void main(String[] args) {
        Animal a1 = new Animal(1001);
        Animal a2 = new Animal(1001);
        Animal a3 = new Animal();
        System.out.print(a1.equals(a2) + " ");
        System.out.println(a2.equals(a3));

    }
}
