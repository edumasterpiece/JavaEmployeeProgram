
package Lab006;

public abstract class Employee extends Person implements Comparable<Employee>{
    //Declaration of Varriables
    private int employeeNo;
    private int departmentNo;
    private Project project;
    
    //main constructor
    public Employee(){}
    
    //variable constructor
    public Employee(String lastName, String firstName, char middleInit, Date birthDate, 
            int employeeNo, int departmentNo, Project project) {
        super(lastName, firstName, middleInit, birthDate);
        this.employeeNo = employeeNo;
        this.departmentNo = departmentNo;
        this.project = project;
    }
    
    //app setters
    public void setEmployeeNo(int employeeNo) {
        this.employeeNo = employeeNo;
    }

    public void setDepartmentNo(int departmentNo) {
        this.departmentNo = departmentNo;
    }

    public void setProject(Project project) {
        this.project = project;
    }
      
    //app getters
    public int getEmployeeNo() {
        return employeeNo;
    }

    public int getDepartmentNo() {
        return departmentNo;
    }

    public Project getProject() {
        return project;
    }

    @Override
    public String toString(){
        String record;
        record = getEmployeeNo()+" : "+getLastName()+", "+getFirstName()+" "+getMiddleInit()+".     "+getEarnings();
        
        return record;
    }
    
    
    public String overTime(){
        String record;
        record = getEmployeeNo()+" : "+getLastName()+", "+getFirstName()+" "+getMiddleInit()+".     ";
        
        return record;
    }

    public abstract float getEarnings();
    
    @Override
    public int compareTo(Employee e) {
        if (this.getEmployeeNo() == e.getEmployeeNo()) {
            return 0;
        } 
        else if (this.getEmployeeNo() > e.getEmployeeNo()) {
            return 1;
        } 
        else{
            return -1;
        }
    }
   
}
