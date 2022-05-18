
package Lab006;

public class Date {
    //declaration variables
    private int year;
    private int month;
    private int day;
    
    //application constructor
    public Date(int theYear, int theMonth, int theDay) {
        setYear(theYear);
        setMonth(theMonth);
        setDay(theDay);
    }
    
    // application setters
    public void setYear(int theYear){
        this.year = theYear;
    }
    public void setMonth(int theMonth) {
        // define months between 1 and 12
        if(theMonth>=1 && theMonth<=12){
            this.month = theMonth;
        }
        else{
            this.month = 1;
        }
    }
    public void setDay(int theDay){
        //define days of the month 
        int[] days = {0, 31, 28,31,30,31,30,31,31,30,31,30,31};
        
        // validation for leap years
        if( month==2 && theDay==29 && (year%400==0 || (year % 4==0 && year % 100 != 0 ))){
            this.day = theDay;
        }
        // day validation for the month
        else if( theDay<1 || theDay > days[month] ){
            theDay = 1;
        }
        else {
            this.day = theDay;
        }
    }
    
    //Application getters
    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
    
    public String toString() {
        String result;        
        result = month+"/"+day+"/"+year;
        
        return result;
    }
}
