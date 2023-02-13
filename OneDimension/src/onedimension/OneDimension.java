package onedimension;
public class OneDimension {
    int marks[];
    public void storeMarks(){
        marks = new int[4];
        System.out.println("Storing Marks. Please wait...");
        marks[0] = 65;
        marks[1] = 47;
        marks[2] = 75;
        marks[3] = 50;
    }
    public void displayMarks(){
        System.out.println("Marks are:");
        for(int i = 0; i<marks.length; i++){
            System.out.println(marks[i]);
        }
        System.out.println("******************");
        for (int x : marks){
            System.out.println(x);
        }
    }
    public static void main(String[] args) {
        OneDimension oneDimenObj = new OneDimension();
        oneDimenObj.storeMarks();
        oneDimenObj.displayMarks();
    }
}
