class Employee extends Person{

    public String start_date;
    public boolean full;
    public int hours;
    public String boss;
    public String job;
    public String project;
    public int salary;
    public boolean manager;

    //Constructor referencing Person
    public Employee(String name, String address, int age, String phone, String start_date,
                    int hours, String boss, String job, String project, int salary, boolean full, boolean manager){

        super(name,address,age,phone);
        this.start_date = start_date;
        this.hours = hours;
        this.boss = boss;
        this.job = job;
        this.project = project;
        this.salary = salary;
        this.manager = manager;
        this.full = full;
    }

    //Adding work hours
    public void addhours(int adding){
        hours += adding;
    }

    //Print all info
    public void info(){
        System.out.println("Full name: " + name + "\n"
                + "Address: " +address+ "\n"
                + "Age: " +age + "\n" 
                + "Phone: " +phone + "\n"
                + "Start Date: " + start_date + "\n"
                + "Total Hours: " +hours+ "\n"
                + "Boss: " +boss + "\n" 
                + "Job: " +job + "\n"
                + "Project: " + project + "\n"
                + "Salary: " +salary+ "\n");
    }

}