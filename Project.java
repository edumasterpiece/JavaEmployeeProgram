
package Lab006;

public class Project implements Comparable<Project>{
    //variables declaration
    private int projectNo;
    private String projectName;
    
    //main constructor
    public Project(){}
    
    //variables constructor
    public Project(int projectNo, String projectName) {
        this.projectNo = projectNo;
        this.projectName = projectName;
    }
        
    //application setters
    public void setProjectNo(int projectNo){
        this.projectNo = projectNo;
    }
    
    public void setProjectName(String projectName){
        this.projectName = projectName;
    }
    
    //application getters
    public int getProjectNo(){
        return projectNo;
    }    
    public String getProjectName(){
       return projectName;
    }
    
    @Override
    public String toString(){
        String p;
        p = "Project#" + getProjectNo() + ": " + getProjectName();
        
        return p;
    }
    
    @Override
    public int compareTo(Project p) {
        if (this.getProjectNo() == p.getProjectNo()){
            return 0;
        } 
        else if (this.getProjectNo() > p.getProjectNo()) {
            return 1;
        } 
        else {
            return -1;
        }
    }

}
