
package Lab006;

public class HourlyEmployee extends Employee {
    //declaration of variables
    private float hourlyRate;
    private float hoursWorked;
    
    //main constructor
    public HourlyEmployee(){}
    
    //variable constructor
    public HourlyEmployee(String lastName, String firstName, char middleInit, 
            Date birthDate, int employeeNo, int departmentNo, Project project, 
            float hourlyRate, float hoursWorked){
        super(lastName, firstName, middleInit, birthDate, employeeNo, departmentNo, project);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }
    
    //application setters
    public void setHourlyRate(float hourlyRate){
        this.hourlyRate = hourlyRate;
    }
    
    public void setHoursWorked(float hoursWorked){
        this.hoursWorked = hoursWorked; 
    }
    
    //application getters
    public float getHourlyRate() {
        return hourlyRate;
    }
    
    public float getHoursWorked() {
        return hoursWorked;
    }
    
    @Override
    public float getEarnings() {
        float earnings = getHoursWorked()*getHourlyRate();
        
        return earnings;
    }
    
}
