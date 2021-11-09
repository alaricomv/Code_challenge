import java.util.Scanner;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {




        int main_menu;
        boolean exit = false;
        String search; 
        String company_search;



        Scanner myscanner = new Scanner(System.in);

        Employee employee = new Employee();
        Company company = new Company();



        ArrayList<String> names = new ArrayList<>();

        names.add("Alarico Mercado");
        names.add("Fernanda Montiel");

        while(!exit){
            System.out.println("Choose action" + "\n" 
                               + "1) Add company " + "\n"
                               + "2) Add employee" + "\n"
                               + "3) Search an employee" + "\n"
                               + "4) Search a Company" + "\n"
                               + "5) Exit ");
            main_menu= myscanner.nextInt();


            switch(main_menu){
                case 1:
                        company.AddCompany();
                        break;
                case 2:
                        //Verifies that the company exists before entering an employee
                        System.out.println("Enter Company name");
                        myscanner.nextLine();
                        String company_name = myscanner.nextLine();

                        boolean prueba = company.find(company_name);

                        System.out.println(prueba);

                        if(company.find(company_name)){
                            employee.AddEmployee(company_name);
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
                       employee.info(search,company_search);
                       break;

                case 4:
                       System.out.println("Enter Company name");
                       myscanner.nextLine();
                       search = myscanner.nextLine();
                       company.Company_info(search);
                       break;

                case 5:
                        exit = true;
                        break;

                default:
                        System.out.println("Choose a valid option");

            }
        }

       
    }
}