import java.util.Scanner;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
import java.util.ArrayList;


class Employee extends Person{

    public ArrayList<String> start_date = new ArrayList<String>();
    public ArrayList<Integer> full = new ArrayList<Integer>();
    public ArrayList<Integer> hours = new ArrayList<Integer>();
    public ArrayList<String> boss = new ArrayList<String>();
    public ArrayList<String> job = new ArrayList<String>();
    public ArrayList<String> project = new ArrayList<String>();
    public ArrayList<String> company = new ArrayList<String>();
    public ArrayList<Integer> salary = new ArrayList<Integer>();
    public ArrayList<Boolean> manager = new ArrayList<Boolean>();

    public Employee(){
       
    }



    public void AddEmployee(String company_name){
        Scanner myscanner = new Scanner(System.in);

        
        
        this.company.add(company_name);

        System.out.println("Enter Full Name");
        String name = myscanner.nextLine();
        System.out.println("Enter Address");
        String address = myscanner.nextLine();
        System.out.println("Enter Age");
        int age = myscanner.nextInt();
        System.out.println("Enter Phone");
        myscanner.nextLine();
        String phone = myscanner.nextLine();

        CreatePerson(name,address,age,phone);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();  
        this.start_date.add(dtf.format(now));
        this.hours.add(0);

        

        System.out.println("Enter Manager name");
        this.boss.add(myscanner.nextLine());
        System.out.println("Enter Job Position");
        this.job.add(myscanner.nextLine());
        System.out.println("Enter Project name");
        this.project.add(myscanner.nextLine());
        System.out.println("Enter Salary");
        this.salary.add(myscanner.nextInt());
        System.out.println("Is the employee a manager? Y/N");
        myscanner.nextLine();
        if(myscanner.nextLine().equals('Y')){
            this.manager.add(true);
        }
        else{
            this.manager.add(false);
        }
        System.out.println("Is this a full time job? Y/N");
        if(myscanner.nextLine().equals("Y")){
            this.full.add(2);
        }
        else{
            this.full.add(1);
        }
        
    }

    //Adding work hours
    public void addhours(int adding, String search){
        int index = -1;
        for(int i = 0; i< name.size();i++){
            if(name.get(i).equals(search)){
                index = i;
            }
        }

        if(index == -1){
            System.out.println("User not found");
        }
        else{
            int original = hours.get(index);
            hours.set(index, original+adding);
        }
    }

    //Print all info
    public void info(String search){

        int index = -1;
        for(int i = 0; i< name.size();i++){
            if(name.get(i).equals(search)){
                index = i;
            }
        }

        if(index == -1){
            System.out.println("User not found");
        }
        else{
        System.out.println("Full name: " + name.get(index) + "\n"
                + "Address: " +address.get(index)+ "\n"
                + "Age: " + age.get(index) + "\n" 
                + "Phone: " + phone.get(index) + "\n"
                + "Start Date: " + start_date.get(index) + "\n"
                + "Total Hours: " +hours.get(index)+ "\n"
                + "Boss: " +boss.get(index) + "\n" 
                + "Job: " +job.get(index) + "\n"
                + "Project: " + project.get(index) + "\n"
                + "Salary: " +salary.get(index)+ "\n");
        }
    }

}