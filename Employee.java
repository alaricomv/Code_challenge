import java.util.Scanner;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

class Employee extends Person{

    public String start_date;
    public int full;
    public int hours;
    public String boss;
    public String job;
    public String project;
    public int salary;
    public boolean manager;



    public void AddEmployee(){

        Scanner myscanner = new Scanner(System.in);

        System.out.println("Enter Full Name");
        String name = myscanner.nextLine();
        System.out.println("Enter Address");
        String address = myscanner.nextLine();
        System.out.println("Enter Age");
        int age = myscanner.nextInt();
        System.out.println("Enter Phone");
        String phone = myscanner.nextLine();

        CreatePerson(name,address,age,phone);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();  
        this.start_date = (dtf.format(now));
        this.hours = 0;

        System.out.println("Enter Manager name");
        this.boss = myscanner.nextLine();
        System.out.println("Enter Job Position");
        this.job = myscanner.nextLine();
        System.out.println("Enter Project name");
        this.project = myscanner.nextLine();
        System.out.println("Enter Salary");
        this.salary = myscanner.nextInt();
        System.out.println("Is the employee a manager? Y/N");
        if(myscanner.nextLine().equals('Y')){
            this.manager = true;
        }
        else{
            this.manager = false;
        }
        System.out.println("Is this a full time job? Y/N");
        if(myscanner.nextLine().equals("Y")){
            this.full = 2;
        }
        else{
            this.full += 1;
        }
        
    }

    //Adding work hours
    public void addhours(int adding){
        hours += adding;
    }

    //Print all info
    public void info(){
        System.out.println("Full name: " + name + "\n"
                + "Address: " +address+ "\n"
                + "Age: " +age + "\n" 
                + "Phone: " +phone + "\n"
                + "Start Date: " + start_date + "\n"
                + "Total Hours: " +hours+ "\n"
                + "Boss: " +boss + "\n" 
                + "Job: " +job + "\n"
                + "Project: " + project + "\n"
                + "Salary: " +salary+ "\n");
    }

}