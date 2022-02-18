package edu.ucalgary.ensf409;

public class Employee {
    private String name;
    private final String IDNUMBER;
    private String managerID;
    private Employee[] supervisedEmployees;

    public Employee(String name, String idNumber){
        this.name = name;
        this.IDNUMBER = idNumber;
    }

    public Employee(String name, String idNumber, String managerID){
        this.name = name;
        this.IDNUMBER = idNumber;
        this.managerID = managerID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIDNumber(){
        return this.IDNUMBER;
    }

    public String getManagerID() {
        return this.managerID;
    }

    public void setManagerID(String newManager){
        this.managerID = newManager;
    }

    public void addEmployee(Employee newEmployee){
        int n;

        if(this.supervisedEmployees != null){
            n = this.supervisedEmployees.length;
        } else { n = 0; }

        if(n == 20){
            throw new IndexOutOfBoundsException("Maximum amount of employees reached");
        }

        Employee[] temp = new Employee[n + 1];

        for (int i = 0; i < n; i++)
            temp[i] = this.supervisedEmployees[i];

        temp[n] = newEmployee;

        this.supervisedEmployees = temp;

    }

    public Employee[] getEmployees(){
        return this.supervisedEmployees;
    }
}
