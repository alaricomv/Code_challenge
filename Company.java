import java.util.ArrayList;

class Company{

    public String company_name;
    public String company_address;
    public String country;
    public ArrayList<String> employees = new ArrayList<String>();


    public void AddCompany(String company_name, String company_address, String country, ArrayList<String> employees){
        System.out.println("Enter Company Name");
        this.company_name = company_name;
        System.out.println("Enter Company Address");
        this.company_address = company_address;
        System.out.println("Enter Company Country");
        this.country = country;
    }

    public void Company_info(){
        System.out.println("Company Name: " + company_name + "\n"
                + "Address: " + company_address+ "\n"
                + "Country: " + country + "\n" 
                + "Employees: ");

                for (int i = 0; i < employees.size(); i++) {
                    System.out.println(employees.get(i));
                }
    }
}
