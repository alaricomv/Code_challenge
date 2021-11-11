import java.util.Scanner;
import java.util.ArrayList;
import java.util.logging.*;

class Main {
    private static Logger logr = Logger.getLogger( Logger.GLOBAL_LOGGER_NAME);
    
    //Logger configuration
    public static void setupLogger(){
        LogManager.getLogManager().reset();
        logr.setLevel(Level.ALL);

        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.SEVERE);
        logr.addHandler(ch);
        
        try{
            FileHandler fh = new FileHandler("myLogger.log");
            fh.setLevel(Level.FINE);
            logr.addHandler(fh);
        }catch(java.io.IOException e){
            logr.log(Level.SEVERE, "File not working", e);
        }


    }
    

    public static void main(String[] args) {

        Main.setupLogger();

        
        boolean repeat = true;
        int main_menu = -1;
        boolean exit = false;
        String search; 
        String company_search;



        Scanner myscanner = new Scanner(System.in);

        Employee employee = new Employee();
        Company company = new Company();



        logr.fine("Start of the program");

        while(!exit){
            System.out.println("Choose action" + "\n" 
                               + "1) Add company " + "\n"
                               + "2) Add employee" + "\n"
                               + "3) Search an employee" + "\n"
                               + "4) Search a Company" + "\n"
                               + "5) Delete a Company" + "\n"
                               + "6) Delete an Employee" + "\n"
                               + "7) Edit an Employee" + "\n"
                               + "8) Save" + "\n"
                               + "9) Load" + "\n"
                               + "10) Exit ");
            
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
                        try{
                            company.AddCompany();
                            logr.fine("Added company correctly");
                        }catch(Exception ex){
                            logr.warning("Error while adding company");
                        }
                        
                        break;
                case 2:
                        //Verifies that the company exists before entering an employee
                        System.out.println("Enter Company name");
                        myscanner.nextLine();
                        String company_name = myscanner.nextLine();

                        boolean prueba = company.find(company_name);


                        if(company.find(company_name)){
                            Boolean complete = employee.AddEmployee(company_name);
                            if(complete == true){
                                company.AddEmployees(company_name,employee.name_enter);
                            }
                            else{
                                logr.info("Failed to create an employee correctly");
                            }
                        }
                        else{
                            System.out.println("Company not found");
                        }
                       
                       break;
                case 3:
                       System.out.println("Enter full employee name");
                       myscanner.nextLine();
                       search = myscanner.nextLine();
                       System.out.println("Enter company name");
                       company_search = myscanner.nextLine();
                       try{
                            employee.info(search,company_search);
                            logr.fine("Employee search complete");
                        }catch(Exception ex){
                            logr.warning("Error while searching");
                        }
                       break;

                case 4:
                       System.out.println("Enter Company name");
                       myscanner.nextLine();
                       search = myscanner.nextLine();
                       try{
                            company.Company_info(search);
                            logr.fine("Company search complete");
                        }catch(Exception ex){
                            logr.warning("Error while searching");
                        }
                       company.Company_info(search);
                       break;
                case 5:
                       System.out.println("Enter Company name");
                       myscanner.nextLine();
                       search = myscanner.nextLine();
                       try{
                            company.Deletecompany(search);
                            logr.fine("Company deleted correctly");
                        }catch(Exception ex){
                            logr.warning("Error while deleting");
                        }
                       break;
                case 6:
                       System.out.println("Enter full employee name");
                       myscanner.nextLine();
                       search = myscanner.nextLine();
                       System.out.println("Enter company name");
                       company_search = myscanner.nextLine();
                       try{
                            employee.Deleteemployee(search,company_search);
                            logr.fine("Employee deleted correctly");
                        }catch(Exception ex){
                            logr.warning("Error while deleting");
                        }
                       
                       break;
                case 7:
                       System.out.println("Enter full employee name");
                       myscanner.nextLine();
                       search = myscanner.nextLine();
                       System.out.println("Enter company name");
                       company_search = myscanner.nextLine();
                       
                       try{
                            employee.Editmenu(search,company_search);
                            logr.fine("Employee edited correctly");
                        }catch(Exception ex){
                            logr.warning("Error while editing");
                        }
                       break;

                case 8:
                        try{
                            employee.saving();
                            company.saving();
                            logr.fine("Saved correctly");
                        }catch(Exception ex){
                            logr.warning("Couldnt save");
                        }
                        break;
                case 9:
                       try{
                            employee.loading();
                            company.loading();
                            logr.fine("Loaded correctly");
                        }catch(Exception ex){
                            logr.warning("Couldnt load");
                        }
                        break;

                case 10:
                        exit = true;
                        break;

                default:
                        System.out.println("Choose a valid option");
                        logr.info("The user did not choose a valid option");
                        break;

            }
        }
         logr.finer("End of the program");

       
    }
}