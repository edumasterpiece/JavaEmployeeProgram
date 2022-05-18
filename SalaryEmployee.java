
package Lab006;

public class SalaryEmployee extends Employee {
    //declaration of variables
    private float monthlySalary;
    
    //main constructor
    public SalaryEmployee(){}
    
    //variable constructor

    public SalaryEmployee(String lastName, String firstName, char middleInit, Date birthDate, 
            int employeeNo, int departmentNo, Project project, float monthlySalary) {
        super(lastName, firstName, middleInit, birthDate, employeeNo, departmentNo, project);
        this.monthlySalary = monthlySalary;
    } 
    
    //application setter
    public void setMonthlySalary(float monthlySalary){
        this.monthlySalary = monthlySalary;
    }
    
    //application getter
    public float getMonthlySalary(){
        return monthlySalary;
    }
    
    @Override
    public float getEarnings(){
        float earnings;
        earnings = getMonthlySalary();
        
        return earnings;
    }
    
}
