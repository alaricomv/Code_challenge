import java.util.Scanner;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException; 


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
    public int age_enter;

    public Employee(){
       
    }



    public Boolean AddEmployee(String company_name){
        boolean repeat = true;

        Scanner myscanner = new Scanner(System.in);
        
        this.company_one = company_name;

        if(hasmanager(company_name) == true){
            first_manager = false;
        }
        else{
            first_manager = true;
        }

        System.out.println("Enter Full Name");
        name_enter = myscanner.nextLine();
        System.out.println("Enter Address");
        String address_enter = myscanner.nextLine();

        while(repeat){
            try{
                System.out.println("Enter Age");
                age_enter = myscanner.nextInt();
                repeat = false;
            } catch(Exception e){
                System.out.println("Numbers only");
                myscanner.next();
                repeat = true;
            }
        }
        repeat = true;
        
        
        
        System.out.println("Enter Phone");
        myscanner.nextLine();
        String phone_enter = myscanner.nextLine();

        

        
        if(first_manager == false){
            System.out.println("Enter Manager name");
            this.boss_one = myscanner.nextLine();
            if(Managerexists(boss_one,company_name)){
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
        
         while(repeat){
            try{
                System.out.println("Enter Salary");
                this.salary_one = myscanner.nextInt();
                repeat = false;
            } catch(Exception e){
                System.out.println("Numbers only");
                myscanner.next();
                repeat = true;
            }
        }
        repeat = true;


        
        

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
        this.company.add(company_one);



        ArrayList<String> inside = new ArrayList<String>();
        inside.add(project_one);
        this.projects_managers.add(inside);
        
        
        this.salary.add(salary_one);




        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();  
        this.start_date.add(dtf.format(now));
        this.hours.add(0);

        return true;
    }

    public boolean hasmanager(String company_name){
        if(company.isEmpty()){
            return false; 
        }
        System.out.println(company.size());
        for(int i = 0; i< company.size();i++){
            if(company.get(i).equalsIgnoreCase(company_name) && manager.get(i) == true){
                return true;
            }
        }

        return false;
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

    //Edit menu
    public void Editmenu(String search, String search_company){

        boolean repeat = true;

        Scanner myscanner = new Scanner(System.in);
        boolean exit = false;
        String new_value_str;
        int new_value_int;
        int main_menu = -1;

        int index = -1;
        for(int i = 0; i< name.size();i++){
            if(name.get(i).equalsIgnoreCase(search)&& company.get(i).equalsIgnoreCase(search_company)){
                index = i;
            }
        }


        if(index == -1){
            System.out.println("User not found");
            return;
        }

        while(!exit){
            System.out.println("Choose action" + "\n" 
                               + "1) Edit address " + "\n"
                               + "2) Edit Age" + "\n"
                               + "3) Edit Phone" + "\n"
                               + "4) Add Hours" + "\n"
                               + "5) Change Manager" + "\n"
                               + "6) Edit Job" + "\n"
                               + "7) Change project" + "\n"
                               + "8) Change Salary" + "\n"
                               + "9) Exit ");
            while(repeat){
                try{
                    main_menu = myscanner.nextInt();
                     repeat = false;
                 } catch(Exception e){
                    System.out.println("Numbers only");
                    myscanner.next();
                    repeat = true;
                }
            }

            repeat = true;

            switch(main_menu){

                  case 1:
                   System.out.println("Enter new address");
                   myscanner.nextLine();
                   new_value_str = myscanner.nextLine();
                   address.set(index, new_value_str);
                   break;
            
            case 2:
                   
                    while(repeat){
                        try{
                             System.out.println("Enter new age");
                             new_value_int = myscanner.nextInt();
                             age.set(index, new_value_int);
                             repeat = false;
                         } catch(Exception e){
                             System.out.println("Numbers only");
                             myscanner.next();
                             repeat = true;
                     }
                   }
                   repeat = true;
                   break;
            case 3:
                   System.out.println("Enter new number");
                   myscanner.nextLine();
                   new_value_str = myscanner.nextLine();
                   phone.set(index, new_value_str);
                   break;
            case 4:
                    while(repeat){
                        try{
                             System.out.println("Hours to add");
                             new_value_int = myscanner.nextInt();
                             addhours(new_value_int,search);
                             repeat = false;
                        } catch(Exception e){
                              System.out.println("Numbers only");
                              myscanner.next();
                              repeat = true;
                         }
                     }
                   repeat = true;
                   break;
            case 5:
                   System.out.println("Enter Manager name");
                    myscanner.nextLine();
                    new_value_str = myscanner.nextLine();
                    if(manager.get(index)){
                        System.out.println("Manager of manager is the CEO");
                        break;
                    }
                    if(Managerexists(new_value_str,search_company)){
                        boss.set(index,new_value_str);
                        break;
                    }
                    else{
                        System.out.println("Manager not found");
                        break;
                    }
            case 6:
                   System.out.println("Enter new job");
                   myscanner.nextLine();
                   new_value_str = myscanner.nextLine();
                   job.set(index, new_value_str);
                   break;
            case 7:
                    managingprojects(index);
                    break;
            case 8:
                    while(repeat){
                    try{
                        System.out.println("Enter new salary");
                         new_value_int = myscanner.nextInt();
                        salary.set(index, new_value_int);
                        repeat = false;
                    } catch(Exception e){
                        System.out.println("Numbers only");
                        myscanner.next();
                        repeat = true;
                     }
                    }
                    repeat = true;
                   break;
            case 9:
                  exit = true;
                  break;
                  

            default :   
                   System.out.print("Select a valid option");
                   break;
            
            }
                   
        }

        return;
        
    }

    //Project menu for Managers
    public void managingprojects(int index){
        boolean repeat = true;
        Scanner myscanner = new Scanner(System.in);
        boolean exit = false;
        String new_value_str;
        int main_menu = -1;


         while(!exit){
            System.out.println("Choose action" + "\n" 
                               + "1) New Project " + "\n"
                               + "2) Delete Project" + "\n"
                               + "3) Exit" + "\n");

            while(repeat){
                try{
                    main_menu = myscanner.nextInt();
                     repeat = false;
                 } catch(Exception e){
                    System.out.println("Numbers only");
                    myscanner.next();
                    repeat = true;
                }
            }

            repeat = true;

            switch(main_menu){
            case 1:
                   System.out.println("Enter name of new project");
                   myscanner.nextLine();
                   new_value_str = myscanner.nextLine();
                   projects_managers.get(index).add(new_value_str);
                   break;
            case 2: 
                   System.out.println("Enter name of project to delete");
                   myscanner.nextLine();
                   new_value_str = myscanner.nextLine();
                   for (int i = 0; i < projects_managers.size(); i++) {
                        for(int j = 0; j < projects_managers.get(i).size(); j++){
                            if(i == index && projects_managers.get(i).get(j).equalsIgnoreCase(new_value_str)){
                                projects_managers.get(i).remove(j);
                            }
                        
                         }
                     }
                     break;
            case 3:
                     exit = true;
                     break;
            }
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
    public boolean Managerexists(String name_manager, String company_name){
        int index = -1;
        for(int i = 0; i< name.size();i++){
            if(name.get(i).equalsIgnoreCase(name_manager) && manager.get(i) == true && company.get(i).equalsIgnoreCase(company_name)){
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

                
                for (int i = 0; i < projects_managers.size(); i++) {
                    for(int j = 0; j < projects_managers.get(i).size(); j++){
                        if(i == index){
                            System.out.println((projects_managers.get(i)).get(j));
                        }
                        
                    }
                }
                
        }
    }

    
    public void loading(){
         try {
            File myObj = new File("employees.txt");
            Scanner myReader = new Scanner(myObj);
            String word = "";
            

            //Loads names
            name.clear();
            String data = myReader.nextLine();
            for(int i = 1; i < data.length()-1; i++){
                if(data.charAt(i)!= ','){
                    word+=data.charAt(i);
                }
                else{
                    name.add(word);
                    word = "";
                }
            }

            name.add(word);
            word = "";



            //Loads Company name
            company.clear();
            data = myReader.nextLine();
            for(int i = 1; i < data.length()-1; i++){
                if(data.charAt(i)!= ','){
                    word+=data.charAt(i);
                }
                else{
                    company.add(word);
                    word = "";
                }
            }

            company.add(word);
            word = "";


            //Loads Address
            address.clear();
            data = myReader.nextLine();
            for(int i = 1; i < data.length()-1; i++){
                if(data.charAt(i)!= ','){
                    word+=data.charAt(i);
                }
                else{
                    address.add(word);
                    word = "";
                }
            }

            address.add(word);
            word = "";

             
            //Loads Age
            age.clear();
            data = myReader.nextLine();
            for(int i = 1; i < data.length()-1; i++){
                if(data.charAt(i)!= ','){
                    word+=data.charAt(i);
                }
                else{
                    age.add(Integer.parseInt(word));
                    word = "";
                }
            }

            age.add(Integer.parseInt(word));
            word = "";


            //Loads Phone
            phone.clear();
            data = myReader.nextLine();
            for(int i = 1; i < data.length()-1; i++){
                if(data.charAt(i)!= ','){
                    word+=data.charAt(i);
                }
                else{
                    phone.add(word);
                    word = "";
                }
            }

            phone.add(word);
            word = "";

            //Loads Start date
            start_date.clear();
            data = myReader.nextLine();
            for(int i = 1; i < data.length()-1; i++){
                if(data.charAt(i)!= ','){
                    word+=data.charAt(i);
                }
                else{
                    start_date.add(word);
                    word = "";
                }
            }

            start_date.add(word);
            word = "";


            //Loads if its full time or half
            full.clear();
            data = myReader.nextLine();
            for(int i = 1; i < data.length()-1; i++){
                if(data.charAt(i)!= ','){
                    word+=data.charAt(i);
                }
                else{
                    full.add(Integer.parseInt(word));
                    word = "";
                }
            }

            full.add(Integer.parseInt(word));
            word = "";

            //Loads total of hours
            hours.clear();
            data = myReader.nextLine();
            for(int i = 1; i < data.length()-1; i++){
                if(data.charAt(i)!= ','){
                    word+=data.charAt(i);
                }
                else{
                    hours.add(Integer.parseInt(word));
                    word = "";
                }
            }

            hours.add(Integer.parseInt(word));
            word = "";


            //Loads Manager
            boss.clear();
            data = myReader.nextLine();
            for(int i = 1; i < data.length()-1; i++){
                if(data.charAt(i)!= ','){
                    word+=data.charAt(i);
                }
                else{
                    boss.add(word);
                    word = "";
                }
            }

            boss.add(word);
            word = "";


            //Loads Job
            job.clear();
            data = myReader.nextLine();
            for(int i = 1; i < data.length()-1; i++){
                if(data.charAt(i)!= ','){
                    word+=data.charAt(i);
                }
                else{
                    job.add(word);
                    word = "";
                }
            }

            job.add(word);
            word = "";




            //Loads Projects
            ArrayList<String> inside = new ArrayList<String>();
            projects_managers.clear();
            data = myReader.nextLine();
            
            for(int i = 1; i < data.length()-1; i++){
                if(data.charAt(i) == '['){
                     inside = new ArrayList<String>();
                }
                else if (data.charAt(i) == ']'){
                    inside.add(word);
                    word = "";
                    projects_managers.add(inside);
                }
                else if (data.charAt(i) == ',') {
                    inside.add(word);
                    word = "";
                }else{
                    word+=data.charAt(i);
                }
            }


            //Loads salary
            salary.clear();
            data = myReader.nextLine();
            for(int i = 1; i < data.length()-1; i++){
                if(data.charAt(i)!= ','){
                    word+=data.charAt(i);
                }
                else{
                    salary.add(Integer.parseInt(word));
                    word = "";
                }
            }

            salary.add(Integer.parseInt(word));
            word = "";

            //Loads if the person is a manager
            manager.clear();
            data = myReader.nextLine();
            for(int i = 1; i < data.length()-1; i++){
                if(data.charAt(i)!= ','){
                    word+=data.charAt(i);
                }
                else{
                    if(word.equalsIgnoreCase("true")){
                        manager.add(true);
                    }
                    else{
                        manager.add(false);
                    }
                    
                    word = "";
                }
            }

            if(word.equalsIgnoreCase("true")){
                        manager.add(true);
                    }
                    else{
                        manager.add(false);
                    }
            word = "";



            
            myReader.close();
         } catch (FileNotFoundException e) {
             System.out.println("An error occurred.");
             e.printStackTrace();
         }

    }

    public void saving(){
        try {
            FileWriter myWriter = new FileWriter("employees.txt");
            //Saves names
            myWriter.write("[");
            for(int i = 0; i < name.size(); i++){
                if(i!=0){
                    myWriter.write(",");
                }
                myWriter.write(name.get(i));
            }
            myWriter.write("]");


             
            //Saves company
            myWriter.write("\n");

            myWriter.write("[");
            for(int i = 0; i < company.size(); i++){
                if(i!=0){
                    myWriter.write(",");
                }
                myWriter.write(company.get(i));
            }
            myWriter.write("]");


            //Saves address

            myWriter.write("\n");

            myWriter.write("[");
            for(int i = 0; i < address.size(); i++){
                if(i!=0){
                    myWriter.write(",");
                }
                myWriter.write(address.get(i));
            }
            myWriter.write("]");


            //Saves age
            myWriter.write("\n");

            myWriter.write("[");
            for(int i = 0; i < age.size(); i++){
                if(i!=0){
                    myWriter.write(",");
                }
                myWriter.write(Integer.toString(age.get(i)));
            }
            myWriter.write("]");


            //Write phone
            myWriter.write("\n");

            myWriter.write("[");
            for(int i = 0; i < phone.size(); i++){
                if(i!=0){
                    myWriter.write(",");
                }
                myWriter.write(phone.get(i));
            }
            myWriter.write("]");

            
            //Write start_date
            myWriter.write("\n");

            myWriter.write("[");
            for(int i = 0; i < start_date.size(); i++){
                if(i!=0){
                    myWriter.write(",");
                }
                myWriter.write(start_date.get(i));
            }
            myWriter.write("]");


            //Saves full time counter
            myWriter.write("\n");

            myWriter.write("[");
            for(int i = 0; i < full.size(); i++){
                if(i!=0){
                    myWriter.write(",");
                }
                myWriter.write(Integer.toString(full.get(i)));
            }
            myWriter.write("]");

            
            //Saves work hours
            myWriter.write("\n");

            myWriter.write("[");
            for(int i = 0; i < hours.size(); i++){
                if(i!=0){
                    myWriter.write(",");
                }
                myWriter.write(Integer.toString(hours.get(i)));
            }
            myWriter.write("]");



            //Write manager
            myWriter.write("\n");

            myWriter.write("[");
            for(int i = 0; i < boss.size(); i++){
                if(i!=0){
                    myWriter.write(",");
                }
                myWriter.write(boss.get(i));
            }
            myWriter.write("]");

             //Write job
            myWriter.write("\n");

            myWriter.write("[");
            for(int i = 0; i < job.size(); i++){
                if(i!=0){
                    myWriter.write(",");
                }
                myWriter.write(job.get(i));
            }
            myWriter.write("]");



             //Write project
            myWriter.write("\n");

            myWriter.write("[");
            for(int i = 0; i < projects_managers.size(); i++){
                myWriter.write("[");
                for(int j = 0; j < projects_managers.get(i).size();j++){
                    if(j!=0){
                    myWriter.write(",");
                    }
                    myWriter.write(projects_managers.get(i).get(j));
                }
                myWriter.write("]");
            }
            myWriter.write("]");



             //Saves salary
            myWriter.write("\n");

            myWriter.write("[");
            for(int i = 0; i < salary.size(); i++){
                if(i!=0){
                    myWriter.write(",");
                }
                myWriter.write(Integer.toString(salary.get(i)));
            }
            myWriter.write("]");



             //Saves If the person is a manager
            myWriter.write("\n");

            myWriter.write("[");
            for(int i = 0; i < manager.size(); i++){
                if(i!=0){
                    myWriter.write(",");
                }
                if(manager.get(i) == true){
                    myWriter.write("true");
                }
                else{
                    myWriter.write("false");
                }
            }
            myWriter.write("]");

            

            
            myWriter.close();
            System.out.println("Successfully Saved");
         } catch (IOException e) {
            System.out.println("An error occurred.");
             e.printStackTrace();
         }

    }



}