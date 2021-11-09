import java.util.ArrayList;

class Person{

    public String name;
    public String address;
    public int age;
    public String phone;

    //Constructor
    public void CreatePerson(String name, String address, int age, String phone){
        this.name = name;
        this.address = address;
        this.age = age;
        this.phone = phone;
    }

    //Print all info
    public void info(){
        System.out.println("Full name: " + name + "\n"
                + "Address: " +address+ "\n"
                + "Age: " +age + "\n" 
                + "Phone: " +phone + "\n");
    }

}