package Com;
import java.util.List;

public class Project {
    private String projectId;
    private String name;
    private String status;
    private List<String> employeeIDs;

    public Project(String projectId, String name, String status, List<String> employeeIDs) {
        this.projectId = projectId;
        this.name = name;
        this.status = status;
        this.employeeIDs = employeeIDs;
    }

    public List<String> getEmployeeIds() {
        return employeeIDs;
    }

    public String getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setEmployeeIds(List<String> employeeIDs) {
        this.employeeIDs = employeeIDs;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String toString() {
        return "project:- { " + "projectId= " + projectId + "name" + name + "status" + status + "employeeIDs"
                + employeeIDs + "}";
    }

}