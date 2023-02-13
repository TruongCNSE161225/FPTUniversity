
public class SLL_SoftDrink_Tester {

    public static void main(String[] args) throws Exception {
        String srcFname = "Source.txt";
        String binFname = "results_bin.txt";
        String txtFname = "results_text.txt";
        SLL_SoftDrink list = new SLL_SoftDrink();
        list.loadFromFile(srcFname);
        System.out.println("Soft drinks in the list:");
        list.printAll();
        System.out.println();
        System.out.println("Soft drinks of Coca:");
        list.printCompanyBased("Coca");
        System.out.println();
        list.reverse();
        System.out.println("Reverse the list:");
        list.printAll();
        System.out.println();
        list.ascSort_Price_then_pLine();
        System.out.println("Ascending sort by price the pLine:");
        list.printAll();
        System.out.println();
        String type = "Beer 33";
        SoftDrink result = list.search(type);
        if (result == null) {
            System.out.println("Search " + type + ": Not found!");
        } else {
            System.out.println("Search: " + result);
        }
        type = "Miranda";
        result = list.search(type);
        if (result == null) {
            System.out.println("Search " + type + ": Not found!");
        } else {
            System.out.println("Search: " + result);
        }
        System.out.println();
        type = "Natural";
        result = list.remove(type);
        if (result == null) {
            System.out.println("Removed failed! " + type);
        } else {
            System.out.println("Removed successfully: " + result);
        }
        type = "Natural orange1";
        result = list.remove(type);
        if (result == null) {
            System.out.println("Removed failed! " + type);
        } else {
            System.out.println("Removed successfully: " + result);
        }
        System.out.println("\nAfter removing:");
        list.printAll();
        list.printAll_binF(binFname);
        list.printAll_txtF(txtFname);
    }
}
