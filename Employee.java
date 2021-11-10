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
    public ArrayList<ArrayList<String>> projects_managers = new ArrayList<ArrayList<String>>();
    public ArrayList<String> company = new ArrayList<String>();
    public ArrayList<Integer> salary = new ArrayList<Integer>();
    public ArrayList<Boolean> manager = new ArrayList<Boolean>();

    public boolean first_manager = true;

    public String start_date_one;
    public int full_one;
    public int hours_one;
    public String boss_one;
    public String job_one;
    public String project_one;
    public String company_one;
    public int salary_one;
    public boolean manager_one;
    public String name_enter;

    public Employee(){
       
    }



    public Boolean AddEmployee(String company_name){

        Scanner myscanner = new Scanner(System.in);
        
        
        this.company.add(company_name);

        System.out.println("Enter Full Name");
        name_enter = myscanner.nextLine();
        System.out.println("Enter Address");
        String address_enter = myscanner.nextLine();
        System.out.println("Enter Age");
        int age_enter = myscanner.nextInt();
        System.out.println("Enter Phone");
        myscanner.nextLine();
        String phone_enter = myscanner.nextLine();

        

        
        if(first_manager == false){
            System.out.println("Enter Manager name");
            this.boss_one = myscanner.nextLine();
            if(Managerexists(boss_one)){
            }
            else{
                System.out.println("Manager not found");
                return false;
            }
        }
        else{
            this.boss_one = "CEO";
        }
        
        
        System.out.println("Enter Job Position");
        this.job_one = myscanner.nextLine();
        

        
        System.out.println("Enter Project name");
        this.project_one = myscanner.nextLine();
        
        System.out.println("Enter Salary");
        this.salary_one = myscanner.nextInt();
        

        myscanner.nextLine();
        System.out.println("Is this a full time job? Y/N");
        if(myscanner.nextLine().equalsIgnoreCase("Y")){
            if(counthoursfull(name_enter)){
                this.full.add(2);
            }
            else{
                System.out.println("Cannot apply to this position");
                return false;
            }
            
        }
        else{
            if(counthourshalf(name_enter)){
                this.full.add(1);
            }
            else{
                System.out.println("Cannot apply to this position");
                return false;
            }
            
        }


        if(first_manager == false){
            System.out.println("Is the employee a manager? Y/N");
            if(myscanner.nextLine().equalsIgnoreCase("Y")){
                manager_one = true;
                this.manager.add(true);
            }
            else{
                manager_one = false;
                this.manager.add(false);
            }
        }
        else{
            manager_one = true;
            this.manager.add(true);
            first_manager = false;
        }

        //Passes all the filters and adds to table the employee
        CreatePerson(name_enter,address_enter,age_enter,phone_enter);

        this.boss.add(boss_one);
        this.job.add(job_one);

        if(manager_one == true){
            ArrayList<String> inside = new ArrayList<String>();
            inside.add(project_one);
            this.projects_managers.add(inside);
        }
        else{
            this.project.add(project_one);
        }
        
        this.salary.add(salary_one);




        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();  
        this.start_date.add(dtf.format(now));
        this.hours.add(0);

        return true;
    }

    //Adding work hours
    public void addhours(int adding, String search){
        int index = -1;
        for(int i = 0; i< name.size();i++){
            if(name.get(i).equalsIgnoreCase(search)){
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

    //Find out if the employee can have a full time job
    public boolean counthoursfull(String name_count){
        int index = -1;
        for(int i = 0; i< name.size();i++){
            if(name.get(i).equalsIgnoreCase(name_count)){
                index = i;
            }
        }
        if(index == -1){
            return true;
        }
        else{
            return false;
        }
    }

    //Checks if the manager in question exists and if they are actually a manager
    public boolean Managerexists(String name_manager){
        int index = -1;
        for(int i = 0; i< name.size();i++){
            if(name.get(i).equalsIgnoreCase(name_manager) && manager.get(i) == true){
                index = i;
            }
        }
        if(index == -1){
            return false;
        }
        else{
            return true;
        }
    }

    //Find out if the employee can have a half time job
    public boolean counthourshalf(String name_count){
        int index = -1;
        int cont = 0;
        for(int i = 0; i< name.size();i++){
            if(name.get(i).equalsIgnoreCase(name_count)){
                index = i;
                cont+=full.get(i);
            }
        }
        if(index == -1){
            return true;
        }
        else{
            if(cont == 1){
                return true;
            }
            else{
                return false;
            } 
        }
    }

    public void Deleteemployee(String search, String company_search){

        int index = -1;
        for(int i = 0; i< name.size();i++){
            if(name.get(i).equalsIgnoreCase(search) && company.get(i).equalsIgnoreCase(company_search)){
                index = i;
            }
        }

        if(index == -1){
            System.out.println("User not found");
        }
        else{
            name.remove(index);
            address.remove(index);
            age.remove(index);
            phone.remove(index);
            start_date.remove(index);
            full.remove(index);
            hours.remove(index);
            boss.remove(index);
            job.remove(index);
            project.remove(index);
            company.remove(index);
            salary.remove(index);
            manager.remove(index);

            System.out.println("User deleted");
        }
    }

    //Print all info
    public void info(String search, String company_search){

        int index = -1;
        for(int i = 0; i< name.size();i++){
            if(name.get(i).equalsIgnoreCase(search) && company.get(i).equalsIgnoreCase(company_search)){
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
                + "Company: " +company.get(index)+ "\n"
                + "Start Date: " + start_date.get(index) + "\n"
                + "Total Hours: " +hours.get(index)+ "\n"
                + "Boss: " +boss.get(index) + "\n" 
                + "Job: " +job.get(index) + "\n"
                + "Salary: " +salary.get(index)+ "\n"
                + "Manager: " +manager.get(index)+ "\n"
                + "Projects: ");

                if(manager.get(index)){
                for (int i = 0; i < projects_managers.size(); i++) {
                    for(int j = 0; j < projects_managers.get(i).size(); j++){
                        if(i == index){
                            System.out.println((projects_managers.get(i)).get(j));
                        }
                        
                    }
                }
                }
                else{
                    System.out.println("Project: " +project.get(index));
                }
        }
    }



}