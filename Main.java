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
            System.out.println("Elija accion");
            main_menu= myscanner.nextInt();


            switch(main_menu){
                case 1:
                       Employee employee = new Employee("Alarico Mercado","Vista Magna 1443",23,"5518294302",
                                         "18/01/19", 500, "Roberto Perez", "Developer", "Cloud", 30000,true,false);
                       employee.info();
                       break;
                case 2: 
                        Company company = new Company("Oracle","Guadiana 155","GUadalajara", names);
                        company.Company_info();
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