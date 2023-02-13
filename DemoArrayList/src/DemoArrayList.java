
public class DemoArrayList {

    public static void main(String[] args) {
        MyArrayList arr = new MyArrayList();
        arr.add(new Product(1, "Coffee"));
        arr.add(new Product(2, "Milk"));
        arr.add(new Product(3, "Coca"));
        System.out.println("****Print Product List****");
        arr.printAllProduct();
        System.out.println("****Get Product by Id****");
        Product p = arr.getProductById(1);
        System.out.println(p);
        System.out.println("Remove Product:" + p.getName());
        arr.removeProduct(p);
        System.out.println("****Print Product List****");
        arr.printAllProduct();
    }
}
