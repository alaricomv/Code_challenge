import java.util.Scanner;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {



        int main_menu;
        boolean exit = false;



        Scanner myscanner = new Scanner(System.in);

        ArrayList<String> names = new ArrayList<>();

        names.add("Alarico Mercado");
        names.add("Fernanda Montiel");

        while(!exit){
            System.out.println("Choose action" + "\n" 
                               + "1) Add company " + "\n"
                               + "2) Add employee" + "\n"
                               + "3) Exit ");
            main_menu= myscanner.nextInt();


            switch(main_menu){
                case 1:
                       Company company = new Company();
                        company.AddCompany("Oracle","Guadiana 155","Guadalajara", names);
                        company.Company_info();
                        break;
                case 2: 
                       Employee employee = new Employee();
                       
                       employee.AddEmployee();
                       employee.info();
                       break;

                case 3:
                        exit = true;
                        break;

                default:
                        System.out.println("Choose a valid option");

            }
        }

       
    }
}