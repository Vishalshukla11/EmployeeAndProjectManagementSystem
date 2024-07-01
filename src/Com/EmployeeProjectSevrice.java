package Com;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeProjectSevrice
{
    public List<String> getProjectNameForEmployee(String employeeID,List<Employee> employees,List<Project> projects)
    {
        List<String> projectNames=new ArrayList<>();
        for(Employee employee :employees)
        {
            if(employee.getEmployeeId().equals(employeeID))
            {
                for(String projectId : employee.getProjectIds())
                {
                    for(Project project : projects)
                    {
                        if(project.getProjectId().equals(projectId))
                        {
                            projectNames.add(project.getName());
                        }
                    }
                }
                break;
            }
        }
        return projectNames;
    }

    public List<String> getEmployeesForProject(String projectID,List<Employee> employees)
    {
        return employees.stream()
           .filter(ele -> ele.getProjectIds().contains(projectID))
           .map(Employee -> Employee.getName())
           .collect(Collectors.toList());
    }

    public Map<String , Long> getTotalProjectsperEmployee(List<Employee> employees)
    {
        return employees.stream()
        .collect(Collectors.toMap(Employee -> Employee.getEmployeeId(), ele ->(long)ele.getProjectIds().size()));
    }

    public Map<String,Long> getDepartmentsAndEmployeeCount(List<Employee> employees)
    {
        return employees.stream()
        .collect(Collectors.groupingBy(Employee -> Employee.getDepartment(),Collectors.counting()));
        //whith the help of gropping we first we get the list of the all cities and store in the map city will be key and name of the city will be value the main 
        //purpose of using groupingBy() is to get group of any perticular thing 

    }

    public List<String> getAlluniqueProjects(List<Employee> employees)
    {
        return employees.stream()
        .flatMap(ele -> ele.getProjectIds().stream())
        .distinct()
        .collect(Collectors.toList());
    }

    public List<String> getEmployeeWithMoreThanNProjects(int n,List<Employee> employees)
    {
        return employees.stream()
        .filter(Emp -> Emp.getProjectIds().size() > n)
        .map(Employee -> Employee.getName())
        .collect(Collectors.toList());
        
    }

    public Map<String,List<String>> getAvtiveprojectsAndEmployees(List<Project> projects,List<Employee> employees)
    {
        return projects.stream()
        .filter(Pro -> "active".equals(Pro.getStatus()))
        .collect(Collectors.toMap(Project -> Project.getName(), Pro -> employees.stream()
        .filter(Emp -> Emp.getProjectIds().contains(Pro.getProjectId()))
        .map(Employee -> Employee.getName())
        .collect(Collectors.toList())));
    }

    public void addEmployee(List<Employee> employees,Employee employee)
    {
        employees.add(employee);
    }

    public void updateEmployee(List<Employee> employees ,String employeeID,String name,String department,List<String> projectIDs)
    {
        employees.stream()
        .filter(Ele -> Ele.getEmployeeId().equals(employeeID))
        .findFirst()
        .ifPresent(Ele -> {
                    Ele.setName(name);
                    Ele.setDepartment(department);
                    Ele.setProjectIds(projectIDs);
                  });
    }

    public void DeleteEmployee(List<Employee> employees,String employeeID)
    {
        employees.removeIf(Emp -> Emp.getEmployeeId().equals(employeeID) );

    }

    public void addProject(List<Project> projects,Project project)
    {
        projects.add(project);
    }

    public void updateProject(List<Project> projects ,String projectID,String name,String status,List<String> employeeIDs)
    {
        projects.stream()
         .filter(Pro -> Pro.getProjectId().equals(projectID))
         .findFirst()
         .ifPresent(Pro -> 
         {
            Pro.setName(name);
            Pro.setStatus(status);
            Pro.setEmployeeIds(employeeIDs);


         });
    }

    public void DeleteProject(List<Project> projects,String projectID)
    {
        projects.removeIf(Pr -> Pr.getProjectId().equals(projectID));
    }

    public void AssigEmployeeToProject(List<Employee> employees,List<Project> projects,String employeeID,String projectID)
    {
        employees.stream()
           .filter(Ele -> Ele.getEmployeeId().equals(employeeID))
           .findFirst()
           .ifPresent(emp -> 
                    projects.stream()
                          .filter(Pro -> Pro.getProjectId().equals(projectID))
                          .findFirst()
                          .ifPresent(pro -> 
                          {
                            emp.getProjectIds().add(projectID);
                            pro.getEmployeeIds().add(employeeID);
                          })
           );
    }

    /*The Optional<T> type in Java is used to represent an object which may or may not contain a non-null value. It's typically used
     in scenarios where a method could potentially return a null value, indicating the absence of a meaningful result. Instead of 
     returning null, which can lead to NullPointerException errors if not handled properly, Optional<T> forces the user to explicitly
      handle the case where no value is present. */
 public Optional<List<String>> getProjectIDsforEmployee(String employeeID,List<Employee> employees)
 {
    Optional<Employee> employeeOptional=employees.stream()
          .filter(employee -> employee.getEmployeeId().equals(employeeID))
          .findAny();

          if(employeeOptional.isPresent())
          {
            Employee employee=employeeOptional.get();
            return Optional.of(employee.getProjectIds());
          }
          else
          {
            return Optional.empty();//employee not found
          }

 }

 public void viewAllEmployees(List<Employee> employees)
 {
    System.out.println("All employees");
    int count=0;
    for(Employee employee : employees)
    {
        System.out.println("Employee ID :- " + employee.getEmployeeId());
        System.out.println("Name:-" + employee.getName());
        System.out.println("Department:-" + employee.getDepartment());
        System.out.println("Project IDs:-" + employee.getProjectIds());
        System.out.println("------------------");
        count++;
    }
    System.out.println("total employee count:- " + count);
 }

 public void viewAllProjects(List<Project> projects)
 {
    System.out.println("All projects ");
    int count=0;
    for(Project project: projects)
    {
        System.out.println("Project ID:-" + project.getProjectId());
        System.out.println("project Name:- " + project.getName());
        System.out.println("Project status:-" + project.getStatus());
       System.out.println("---------------------------------------------------------");
       count++;
    }
    System.out.println("Count of all projects are :- " + count);
 }

}