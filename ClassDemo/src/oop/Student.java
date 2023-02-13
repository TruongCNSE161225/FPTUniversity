package oop;
public class Student {
    private String id;
    private String fullName;
    public Student(){
        id = "000";
        fullName = "No name";
    }
    public Student(String id, String fullName){
        this.id = id;
        this.fullName = fullName;
    }
    public String getId(){
        return id;
    }
    public void setId(String id) throws Exception{
        if(id.isEmpty()){
            throw new Exception("Idinvalid.");
        }
        this.id = id;
    }
    public String getFullName(){
        return fullName;
    }
    public void setFullName(String fullName) throws Exception {
        if(fullName.isEmpty()){
            throw new Exception("FullName invalid.");
        }
        this.fullName = fullName;
    }
    public void print(){
        System.out.println("Student info:");
        System.out.printf("Id:%s,Fullname:%s\n",id,fullName.toUpperCase());
    }
}
