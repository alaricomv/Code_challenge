import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException; 

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

    public void deleteEmployees(String search_employee, String search_company){
        int index = -1;
        for(int i = 0; i< company_name.size();i++){
            if(company_name.get(i).equalsIgnoreCase(search_company)){
                index = i;
            }
        }
        
        for(int i = 0; i < employees.get(index).size();i++){
            if(employees.get(index).get(i).equalsIgnoreCase(search_employee)){
                employees.get(index).remove(i);
            }
        }

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

    public void loading(){
         try {
            File myObj = new File("companies.txt");
            Scanner myReader = new Scanner(myObj);
            String word = "";
            

            //Loads company names
            company_name.clear();
            String data = myReader.nextLine();
            for(int i = 1; i < data.length()-1; i++){
                if(data.charAt(i)!= ','){
                    word+=data.charAt(i);
                }
                else{
                    company_name.add(word);
                    word = "";
                }
            }

            company_name.add(word);
            word = "";



            //Loads company address
            company_address.clear();
            data = myReader.nextLine();
            for(int i = 1; i < data.length()-1; i++){
                if(data.charAt(i)!= ','){
                    word+=data.charAt(i);
                }
                else{
                    company_address.add(word);
                    word = "";
                }
            }

            company_address.add(word);
            word = "";


            //Loads company country
            country.clear();
            data = myReader.nextLine();
            for(int i = 1; i < data.length()-1; i++){
                if(data.charAt(i)!= ','){
                    word+=data.charAt(i);
                }
                else{
                    country.add(word);
                    word = "";
                }
            }

            country.add(word);
            word = "";


            //Loads employees
            ArrayList<String> inside = new ArrayList<String>();
            employees.clear();
            data = myReader.nextLine();
            
            for(int i = 1; i < data.length()-1; i++){
                if(data.charAt(i) == '['){
                    inside = new ArrayList<String>();
                }
                else if (data.charAt(i) == ']'){
                    inside.add(word);
                    word = "";
                    employees.add(inside);
                }
                else if (data.charAt(i) == ',') {
                    inside.add(word);
                    word = "";
                }else{
                    word+=data.charAt(i);
                }
            }


            
            myReader.close();
         } catch (FileNotFoundException e) {
             System.out.println("An error occurred.");
             e.printStackTrace();
         }

    }

    public void saving(){
        try {
            FileWriter myWriter = new FileWriter("companies.txt");
            //Saves company names
            myWriter.write("[");
            for(int i = 0; i < company_name.size(); i++){
                if(i!=0){
                    myWriter.write(",");
                }
                myWriter.write(company_name.get(i));
            }
            myWriter.write("]");


             
            //Saves company adresses
            myWriter.write("\n");

            myWriter.write("[");
            for(int i = 0; i < company_address.size(); i++){
                if(i!=0){
                    myWriter.write(",");
                }
                myWriter.write(company_address.get(i));
            }
            myWriter.write("]");


            //Saves country

            myWriter.write("\n");

            myWriter.write("[");
            for(int i = 0; i < country.size(); i++){
                if(i!=0){
                    myWriter.write(",");
                }
                myWriter.write(country.get(i));
            }
            myWriter.write("]");



             //Write employees working for the company
            myWriter.write("\n");

            myWriter.write("[");
            for(int i = 0; i < employees.size(); i++){
                myWriter.write("[");
                for(int j = 0; j < employees.get(i).size();j++){
                    if(j!=0){
                    myWriter.write(",");
                    }
                    myWriter.write(employees.get(i).get(j));
                }
                myWriter.write("]");
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
