import java.util.ArrayList;
import java.util.Scanner;

class Company{

    public ArrayList<String> company_name = new ArrayList<String>();
    public ArrayList<String> company_address = new ArrayList<String>();
    public ArrayList<String> country = new ArrayList<String>();
    public ArrayList<ArrayList<String>> employees = new ArrayList<ArrayList<String>>();


    public void AddCompany(){
        Scanner myscanner = new Scanner(System.in);

        System.out.println("Enter Company Name");
        this.company_name.add(myscanner.nextLine());
        System.out.println("Enter Company Address");
        this.company_address.add(myscanner.nextLine());
        System.out.println("Enter Company Country");
        this.country.add(myscanner.nextLine());
    }

    public void Company_info(String search){
        int index = -1;
        for(int i = 0; i< company_name.size();i++){
            if(company_name.get(i).equals(search)){
                index = i;
            }
        }

        if(index == -1){
            System.out.println("Company not found");
        }
        else{
        System.out.println("Company name: " + company_name.get(index) + "\n"
                + "Address: " +company_address.get(index)+ "\n"
                + "Country: " + country.get(index) + "\n" 
                + "Employees: ");


                for (int i = 0; i < employees.size(); i++) {
                    for(int j = 0; i < employees.get(i).size(); j++){
                        System.out.println((employees.get(i)).get(j));
                    }
                }

                System.out.println();
        }
                
    }
}
