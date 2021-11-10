import java.util.ArrayList;
import java.util.Scanner;

class Company{

    public ArrayList<String> company_name = new ArrayList<String>();
    public ArrayList<String> company_address = new ArrayList<String>();
    public ArrayList<String> country = new ArrayList<String>();
    public ArrayList<ArrayList<String>> employees = new ArrayList<ArrayList<String>>();


    //Adds a company
    public void AddCompany(){
        Scanner myscanner = new Scanner(System.in);

        System.out.println("Enter Company Name");
        this.company_name.add(myscanner.nextLine());
        System.out.println("Enter Company Address");
        this.company_address.add(myscanner.nextLine());
        System.out.println("Enter Company Country");
        this.country.add(myscanner.nextLine());
        ArrayList<String> inside = new ArrayList<String>();
        this.employees.add(inside);
    }

    //Adds employees to company
    public void AddEmployees(String company_find, String employee_name){
        int index = -1;
        for(int i = 0; i< company_name.size();i++){
            if(company_name.get(i).equalsIgnoreCase(company_find)){
                index = i;
            }
        }
        employees.get(index).add(employee_name);
    }

    //Delete a company by name
    public void Deletecompany(String company_find){
        int index = -1;
        for(int i = 0; i< company_name.size();i++){
            if(company_name.get(i).equalsIgnoreCase(company_find)){
                index = i;
            }
        }

        if(index != -1){
            company_name.remove(index);
            company_address.remove(index);
            country.remove(index);
            employees.remove(index);
            System.out.println("Company deleted");
        }
        else{
            System.out.println("Company not found");
        }
        
    }

    //Finds if the company is registered
    public boolean find(String search){
        boolean company_found = false;
        for(int i = 0; i< company_name.size();i++){
            if(company_name.get(i).equalsIgnoreCase(search)){
                company_found = true;
            }
        }

        return company_found;

    }

    //Finds the info of an specific company
    public void Company_info(String search){
        int index = -1;
        for(int i = 0; i< company_name.size();i++){
            if(company_name.get(i).equalsIgnoreCase(search)){
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
                    for(int j = 0; j < employees.get(i).size(); j++){
                        if(i == index){
                            System.out.println((employees.get(i)).get(j));
                        }
                        
                    }
                }

                System.out.println();
        }
                
    }
}
