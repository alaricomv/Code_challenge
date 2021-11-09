import java.util.Scanner;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {

        Employee employee = new Employee("Alarico Mercado","Vista Magna 1443",23,"5518294302",
                                         "18/01/19", 500, "Roberto Perez", "Developer", "Cloud", 30000,true,false);
        employee.info();

        ArrayList<String> names = new ArrayList<>();

        names.add("Alarico Mercado");
        names.add("Fernanda Montiel");


        Company company = new Company("Oracle","Guadiana 155","GUadalajara",
                                      names);
        company.Company_info();
    }
}