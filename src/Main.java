import Com.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // sample data for employee and project
        Employee e1 = new Employee("E1", "vishal", "HR", new ArrayList<>(Arrays.asList("P1", "P2")));
        Employee e2 = new Employee("E2", "vikram", "Developer", new ArrayList<>(Arrays.asList("P2", "P4")));
        Employee e3 = new Employee("E3", "vipul", "Tester", new ArrayList<>(Arrays.asList("P3", "P1")));
        Employee e4 = new Employee("E4", "vinay", "HR", new ArrayList<>(Arrays.asList("P4", "P2")));
        Employee e5 = new Employee("E5", "vivek", "Tester", new ArrayList<>(Arrays.asList("P5", "P3")));

        // project sample
        Project p1 = new Project("P1", "Whatsaap", "active", new ArrayList<>(Arrays.asList("E1", "E3")));
        Project p2 = new Project("P2", "faceBook", "pending", new ArrayList<>(Arrays.asList("E1", "E2")));
        Project p3 = new Project("P3", "Spotify", "active", new ArrayList<>(Arrays.asList("E2", "E3")));
        Project p4 = new Project("P4", "Youtube", "complete", new ArrayList<>(Arrays.asList("E4", "E1")));
        Project p5 = new Project("P5", "Gmail", "complete", new ArrayList<>(Arrays.asList("E5")));

        List<Employee> employees = new ArrayList<>(Arrays.asList(e1, e2, e3, e4, e5));
        List<Project> projects = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5));

        EmployeeProjectSevrice sevrice = new EmployeeProjectSevrice();
         boolean MainRunning=true;

        while (MainRunning) { 
        System.out.println("How do you want to login? (1: Employee ,2: Manager)");
        int loginChoice = sc.nextInt();
        sc.nextLine();
        // for employee
        switch(loginChoice) {
        case 1:
            // Employee menu
            System.out.println("Enter your employee ID");
            String employeeID = sc.nextLine();
            boolean Employeerunning = true;
            
            while (Employeerunning) {
                System.out.println("Employee menu: ");
                System.out.println("1. view your projects");
                System.out.println("2. view colleauge on a project");
                System.out.println("3. get you project id ");
                System.out.println("4. Exit");
                int choice = sc.nextInt();
                sc.nextLine();// consume next line
                
                switch (choice) {
                    case 1:
                        List<String> projectNames = sevrice.getProjectNameForEmployee(employeeID, employees, projects);
                        System.out.println("Your projects: " + projectNames);
                        break;
                    case 2:
                        System.out.println("Enter project ID:");
                        String projectID = sc.nextLine();
                        List<String> colleagues = sevrice.getEmployeesForProject(projectID, employees);
                        System.out.println("Colleagues on project " + projectID + ": " + colleagues);
                        break;
                    case 3:
                    System.out.println("Enter yout Employee ID ");
                    String empid=sc.nextLine();
                    Optional<List<String>> proid=sevrice.getProjectIDsforEmployee(empid, employees);
                    System.out.println("project ids for employee: " + employeeID + ": " + proid);
                    break;
                    case 4:
                         Employeerunning= false;
                        break;

                    default:
                        System.out.println("Invalid choice please try again.");
                        break;
                }

            }
        break;
        case 2:
          
            boolean managerRunning = true;
            while (managerRunning)

            {
                System.out.println("Manager Menu:");
                System.out.println("1. view all employees ");
                System.out.println("2.  view all projects for an employee");
                System.out.println("3.  view all employees for a project");
                System.out.println("4.  view total projects pe employee");
                System.out.println("5.  view departments and employee count ");
                System.out.println("6.  view all unique projects");
                System.out.println("7.  view employees with more than N projects");
                System.out.println("8.  view active projects and employees");
                System.out.println("9.  add an employee");
                System.out.println("10.  update an employee");
                System.out.println("11. Delete an employee");
                System.out.println("12. add a project");
                System.out.println("13. update a project");
                System.out.println("14. Delete a project");
                System.out.println("15. assign an employee to a project");
                System.out.println("16. View all projects ");
                System.out.println("17. Exit...........");
               
                int choice = sc.nextInt();
                sc.nextLine();// consume new line

                switch (choice) {
                    case 1:
                    sevrice.viewAllEmployees(employees);
                    break;
                    case 2:
                        System.out.println("Enter employee ID");
                        String empID = sc.nextLine();
                        List<String> empProjectName = sevrice.getProjectNameForEmployee(empID, employees, projects);
                        System.out.println("Project for employee " + empID + " : " + empProjectName);
                        break;
                    case 3:
                        System.out.println("Enter project ID:");
                        String projId = sc.nextLine();
                        List<String> projectEmployees = sevrice.getEmployeesForProject(projId, employees);
                        System.out.println(" employees for project " + projId + ": " + projectEmployees);
                        break;
                    case 4:
                        Map<String, Long> totalProjectPerEmployee = sevrice.getTotalProjectsperEmployee(employees);
                        System.out.println("Total project per eployee :- " + totalProjectPerEmployee);
                        break;
                    case 5:
                        Map<String, Long> departmentsAndEmployeeCount = sevrice
                                .getDepartmentsAndEmployeeCount(employees);
                        System.out.println("All unique projects:-" + departmentsAndEmployeeCount);
                        break;
                    case 6:
                        List<String> alluniqueProjects = sevrice.getAlluniqueProjects(employees);
                        System.out.println("All unique projects:-" + alluniqueProjects);
                        break;
                    case 7:
                        System.out.println("Enter the number of projects ");
                        int n = sc.nextInt();
                        sc.nextLine();
                        List<String> employeeWithMoreThanNProjects = sevrice.getEmployeeWithMoreThanNProjects(n,
                                employees);
                        System.out
                                .println("Employee With more than " + n + " projects " + employeeWithMoreThanNProjects);
                        break;
                    case 8:
                        Map<String, List<String>> activprojectsAndemployees = sevrice
                                .getAvtiveprojectsAndEmployees(projects, employees);
                        System.out.println("Active projects and employees : " + activprojectsAndemployees);
                        break;
                    case 9:
                        System.out.println("Enter new employee details (ID,NAME,DEPARTMENT):");
                        String newEmpId = sc.nextLine();
                        String newName = sc.nextLine();
                        String newDept = sc.nextLine();
                        Employee newEmployee = new Employee(newEmpId, newName, newDept, new ArrayList<>());
                        sevrice.addEmployee(employees, newEmployee);
                        System.out.println("Employee added.");
                        break;
                    case 10:
                        System.out.println("Enter employee Id to update:");
                        String updateEmpID = sc.nextLine();
                        System.out.println("Enter new name,new department,and project IDs (comma-seperated):");
                        String updateName = sc.nextLine();
                        String updateDept = sc.nextLine();
                        List<String> updateProjectIDs = Arrays.asList(sc.nextLine().split(","));
                        sevrice.updateEmployee(employees, updateEmpID, updateName, updateDept, updateProjectIDs);
                        System.out.println("Employee update.");
                        break;
                    case 11:
                        System.out.println("Enter employee ID to delete :");
                        String deleteEmpID = sc.nextLine();
                        sevrice.DeleteEmployee(employees, deleteEmpID);
                        System.out.println("employee Deleted successfully");
                        break;
                    case 12:
                        System.out.println("Enter new Project details (ID,Name,Status):");
                        String newProjID = sc.nextLine();
                        String newProJName = sc.nextLine();
                        String newProJectStatus = sc.nextLine();
                        Project newProject = new Project(newProjID, newProJName, newProJectStatus, new ArrayList<>());
                        sevrice.addProject(projects, newProject);
                        System.out.println("Project added.");
                        break;
                    case 13:
                        System.out.println("Enter project Id to update:");
                        String updateProjectID = sc.nextLine();
                        System.out.println("Enter new name,new Status,and employee Ids(Comma-separated):");
                        String updateProjName = sc.nextLine();
                        String UpdatedProjStatus = sc.nextLine();
                        List<String> updateEmpIDs = Arrays.asList(sc.nextLine().split(","));
                        sevrice.updateProject(projects, updateProjectID, updateProjName, UpdatedProjStatus,
                                updateEmpIDs);
                        System.out.println("Project updated.");
                        break;
                    case 14:
                        System.out.println("Enter project Id to delete ");
                        String deleteProjID = sc.nextLine();
                        sevrice.DeleteProject(projects, deleteProjID);
                        System.out.println("Project deleted");
                        break;
                    case 15:
                        System.out.println("Enter employee Id and project Id to assign : ");
                        String assignEmpID = sc.nextLine();
                        String assignproJId = sc.nextLine();
                        sevrice.AssigEmployeeToProject(employees, projects, assignEmpID, assignproJId);
                        System.out.println("Employee assigned to project.");
                        break;
                        case 16:
                        sevrice.viewAllProjects(projects);
                        break;
                    case 17:
                        managerRunning = false;
                    break;
                   
                    default:
                        System.out.println("Invalid choice please try again");
                    break;
                }
            }
            break;

            case 3 :
            MainRunning=false;
            break;
           
           default :
            System.out.println("Invalid login choice .Exiting");
            break;
        }
    }
    sc.close();
    } 
}
