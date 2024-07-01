package Com;
import java.util.List;
public class Employee
{
    private String employeeId;
    private String name;
    private String department;
    private List<String> projectIDs;

    public Employee(String employeeId,String name,String department,List<String> projectIDs)
    {
        this.employeeId=employeeId;
        this.name=name;
        this.department=department;
        this.projectIDs=projectIDs;
    }
    public List<String> getProjectIds()
    {
        return projectIDs;
    }
    public String getDepartment()
    {
        return department;
    }
    public String getName()
    {
        return name;
    }
    public String getEmployeeId()
    {
        return employeeId;
    }
    public void setEmployeeId(String employeeId)
    {
        this.employeeId=employeeId;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public void setDepartment(String department)
    {
        this.department=department;
    }
    public void setProjectIds(List<String> projectsIDs)
    {
        this.projectIDs=projectsIDs;
    }

    public String toString()
    {
        return "Employee:-{ "+ "employeeID= " + employeeId + "Name= " + name + "department=" + department + "projectIDs= " + projectIDs + "}";
    }
}
