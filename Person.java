
package Lab006;

public class Person {
    
    //declaration of variables
    private String lastName;
    private String firstName;
    private char middleInit;
    private Date birthDate;
    
    //main constructor
    public Person(){}
    
    //variables' constructor
    public Person(String lastName, String firstName, char middleInit, Date birthDate){
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleInit = middleInit;
        this.birthDate = birthDate;
    }
    
    //application getters
    public String getLastName(){ 
        return lastName; 
    }
    
    public String getFirstName(){ 
        return firstName; 
    }
    public char getMiddleInit(){ 
        return middleInit; 
    }
    public Date getBirthDate(){ 
        return birthDate; 
    }
    
    //application setters
    public void setLastName(String lastName){ 
        this.lastName = lastName; 
    }
    public void setFirstName(String firstName){ 
        this.firstName = firstName; 
    }
    public void setMiddleInit(char middleInit){ 
        this.middleInit = middleInit; 
    }
    public void setBirthDate(Date birthDate){ 
        this.birthDate = birthDate; 
    }
    
    //method to return Person's full name
    @Override
    public String toString(){
        String result;        
        result = lastName+", "+firstName+" "+middleInit+".";
        
        return result;
    }
    
    public String displayFormattedDate(){
        String d = getBirthDate().toString();
        return d;
    }
    
    //method to write record
    public String writeAsRecord(){
    String record;
    record = getFirstName() + " " + getLastName() + " " + getMiddleInit() + " " + getBirthDate().getMonth() + 
           " "+  getBirthDate().getDay() + " " + getBirthDate().getYear();
    return record;
    }
}
