import java.util.Scanner;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {




        int main_menu;
        boolean exit = false;
        String search; 



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
                       employee.AddEmployee();
                       break;
                case 3:
                       System.out.println("Enter full employee name");
                       myscanner.nextLine();
                       search = myscanner.nextLine();
                       employee.info(search);
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