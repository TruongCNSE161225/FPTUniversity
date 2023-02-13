import java.util.ArrayList;
public class Product {
    private int id;
    private String name;

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString(){
        return "Product{id="+id+", name="+name+"}";
    }
}

interface IProduct {
    void printAllProduct();
    void addProduct (Product p);
    void removeProduct(Product p);
    Product getProductById(int id);
}

class MyArrayList extends ArrayList<Product> implements IProduct {

    @Override
    public void printAllProduct() {
        for (Product p : this) {
            System.out.println(p);
        }
    }

    @Override
    public void addProduct(Product p) {
        this.add(p);
    }

    @Override
    public void removeProduct(Product p) {
        this.remove(p);
    }

    @Override
    public Product getProductById(int id) {
        Product pro = this.stream()
                .filter(p -> p.getId() == id)
                .findAny()
                .orElse(null);
        return pro;
    }
}