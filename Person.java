import java.util.ArrayList;

class Person{

    public ArrayList<String> name = new ArrayList<String>();
    public ArrayList<String> address = new ArrayList<String>();
    public ArrayList<Integer> age = new ArrayList<Integer>();
    public ArrayList<String> phone = new ArrayList<String>();

    //Constructor
    public void CreatePerson(String name, String address, int age, String phone){
        this.name.add(name);
        this.address.add(address);
        this.age.add(age);
        this.phone.add(phone);
    }

    /*
    public void info(){
        System.out.println("Full name: " + name + "\n"
                + "Address: " +address+ "\n"
                + "Age: " +age + "\n" 
                + "Phone: " +phone + "\n");
    }
    */

}