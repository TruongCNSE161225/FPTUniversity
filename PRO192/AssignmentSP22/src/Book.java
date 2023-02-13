
public class Book implements Comparable<Book>{

    String Code;
    String Title;
    float UnitPrice;
    int Quantity;

    public Book() {
    }

    public Book(String Code, String Title, float UnitPrice, int Quantity) {
        this.Code = Code;
        this.Title = Title;
        this.UnitPrice = UnitPrice;
        this.Quantity = Quantity;
    }

    public String getCode() {
        return Code;
    }

    public String getTitle() {
        return Title;
    }

    public float getUnitPrice() {
        return UnitPrice;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public void setUnitPrice(float UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    @Override
    public String toString() {
        return "Code: " + Code + ", " + "Book title: " + Title + ", " + "Price: " + UnitPrice + ", " + "Quantity: " + Quantity;
    }

    @Override
    public int compareTo(Book o) {
        Book a = (Book) o;
        if (this.getQuantity() > a.getQuantity()) {
            return -1;
        } else if (this.getQuantity() < a.getQuantity()) {
            return 1;
        }
        return 0;
    }
}
