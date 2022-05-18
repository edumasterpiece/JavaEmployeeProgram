
package DriveProgram;

import Lab006.Date;
import Lab006.Employee;
import Lab006.HourlyEmployee;
import Lab006.Project;
import Lab006.SalaryEmployee;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PayrollReporter {
    //declaration of variables
    static Employee[] employees;
    static Scanner input;
    static Project[] projects;
   
    public void getData(){
        //project array declaration
        projects = new Project[10];
        //projects array
        projects[0] = new Project(12, "Payroll Reporter");
        projects[1] = new Project(0, "Unassigned");
        projects[2] = new Project(9, "Softco Salt Calculator");
        projects[3] = new Project(15, "OT Calculator");        
        
        //declaration of array employees
        employees = new Employee[10];
        //array of employees
        employees[0] = new SalaryEmployee("John", "Smith", 'T', new Date(6,24,80), 100101, 1, projects[0], 2894.54f);
        employees[1] = new SalaryEmployee("Sue", "Jones", 'A', new Date(4,13,84), 100102, 1, projects[1], 3110.0f);
        employees[2] = new HourlyEmployee("Marg", "Williams", 'C', new Date(1,28,70), 100103, 3, projects[2], 25.0f,81f);
        employees[3] = new SalaryEmployee("Beth", "Davies", 'D', new Date(2,3,76), 200101, 3, projects[3], 2843.5f);
        employees[4] = new SalaryEmployee("Jake", "Stewart", 'A', new Date(9,18,68), 100201, 1, projects[2], 2999.0f);
        employees[5] = new HourlyEmployee("Alice", "McWilliams", 'F', new Date(10,9,80), 300203, 1, projects[0], 27.0f, 88f);		
        employees[6] = new HourlyEmployee("Mike", "Klauss", 'M', new Date(12,12,76), 300213, 2, projects[1], 30.0f, 80f);		
        employees[7] = new HourlyEmployee("Samuelle", "Chau", 'D', new Date(8,23,86), 400213, 2, projects[2], 22.0f, 85f);
        employees[8] = new HourlyEmployee("Mitch", "Flynn", 'A', new Date(7,28,78), 990223, 3, projects[3], 100.0f, 80f);
        employees[9] = new SalaryEmployee("Andrea", "Bouchard", 'S', new Date(3,20,85), 400023, 3, projects[2], 3900.0f); 
        
    }
    
    //menu for user selection
    public int showMenu(){
        input = new Scanner(System.in);
        int choice = 0;
        
        do{
            System.out.println("1. Display all earnings for employees");
            System.out.println("2. Display all earnings for a project number");
            System.out.println("3. Display all earnings for a department number");
            System.out.println("4. Display wage costs for all projects");
            System.out.println("5. Display wage costs for all departments");
            System.out.println("6. Display overtimes expenses");
            System.out.println("7. Exit");
        
            choice = input.nextInt();
            
            if (choice<1 || choice>7){
                System.out.println("Invalid choice!");
            }
        }
        while(choice<1 || choice>7);
        
        return choice;
    }
    
    public void executeChoice(int choice){
        switch(choice){
            case 1:
                menuOption1();
                break;
            case 2:
                menuOption2();
                break;
            case 3:
                menuOption3();
                break;
            case 4:
                menuOption4();
                break;
            case 5:
                menuOption5();
                break;
            case 6:
                menuOption6();
                break;
            case 7:
                System.exit(0);
                break;
        }  
    }
    
    public void menuOption1(){
        System.out.println();
        // loop through the list of employees
        
        for (Employee p : employees ){
            //display the employees' info
            Arrays.sort(employees);
            System.out.println(p.toString());
        }
    }
    
    // display earnings by project number
    public void menuOption2(){
        //declaration of variables
        int projNo = 0;
        System.out.println("Enter Project No. to Display Earnings: ");
        projNo = input.nextInt();
        
        boolean projNoFound = false;
        //System.out.println("Project#"+projNo);
        for (Employee emp : employees) {
            if (projNo == (emp.getProject().getProjectNo())) {
                projNoFound = true;
                // display the employees' info
                System.out.println("Project#"+emp.getProject().getProjectNo()
                        +" : "+emp.getProject().getProjectName()+"  "+emp.toString());
            } 
        }
        if(!projNoFound){
            System.out.println("The Project No: " + projNo + " is not found!");
        }

    }
    
    // display earnings by department 
    public void menuOption3(){
        //declaration of variables
        int depNo = 0;
        System.out.println("Enter Department No. to Display Earnings: ");
        depNo = input.nextInt();
        
        boolean depNoFound = false;
        System.out.println("Department#"+depNo);
        for(Employee emp: employees){
            if(depNo==(emp.getDepartmentNo())){
                depNoFound = true;
                // display the employees' info                
                System.out.println(emp.toString());
            } 
        }
        if(!depNoFound){
            System.out.println("The Department No: "+depNo+" is not found!");
        }
    }
    
     // display earnings by project number 
    public void menuOption4(){
        //declaration of variables
        int projNo;
        float sum = 0;
        System.out.println("Enter Project No. to Display Total Earnings: ");
        projNo = input.nextInt();
        
        boolean projNoFound = false;
        for(Employee emp: employees){
            if(projNo==(emp.getProject().getProjectNo())){
                projNoFound = true;                
                // display the employees' info 
                sum += emp.getEarnings();
                System.out.println("Project#"+emp.getProject().getProjectNo()
                        +" : "+emp.getProject().getProjectName()+"  "+ sum);
            } 
        }
        if(!projNoFound){
            System.out.println("The Project No: "+projNo+" is not found!");
        }
    }
    
     // display wage costs for all projects
    public void menuOption5(){
        //declaration of variables
        float sum = 0;
        
        for (Employee emp : employees) {
            // display the employees
            sum += emp.getEarnings();
            //Arrays.sort(projects);
            System.out.println(emp.getProject().getProjectNo() + " : " + sum);
        }
    }
    
    // display overtime expenses 
    public void menuOption6(){
        for(int i=0; i<employees.length; i++){
            if(employees[i] instanceof HourlyEmployee)
{                HourlyEmployee overTime = (HourlyEmployee)employees[i];
                if(overTime.getHoursWorked() > 80){
                    System.out.println(i + ". " + employees[i].overTime() + (overTime.getHoursWorked()-80)
                            + " : " + (overTime.getHourlyRate() * 1.5f * (overTime.getHoursWorked()-80)));
                }
            }
            
        }

    }

    public static void main(String[] args) {
        //variables declaration
        int choice;
        PayrollReporter pr = new PayrollReporter();
        
        pr.getData();
        
        do{            
            System.out.println("=======================");
            choice = pr.showMenu();
            System.out.println("=======================");
            pr.executeChoice(choice);
        
        }
        while(choice != 7);
    }
    
    
}

