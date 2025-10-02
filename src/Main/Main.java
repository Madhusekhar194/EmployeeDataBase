package Main;

import java.util.*;

import DAO.EmployeeDAO;
import Entity.Employee;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();
        int choice;

        do {
            System.out.println("\n=== Employee DB App ===");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter Role: ");
                    String role = sc.next();
                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();
                    dao.addEmployee(new Employee(name, role, salary));
                    break;
                case 2:
                    dao.getEmployees().forEach(emp ->
                        System.out.println(emp.getId() + " | " + emp.getName() + " | " + emp.getRole() + " | " + emp.getSalary()));
                    break;
                case 3:
                    System.out.print("Enter ID to Update: ");
                    int uid = sc.nextInt();
                    System.out.print("Enter new Role: ");
                    String newRole = sc.next();
                    System.out.print("Enter new Salary: ");
                    double newSalary = sc.nextDouble();
                    dao.updateEmployee(uid, newRole, newSalary);
                    break;
                case 4:
                    System.out.print("Enter ID to Delete: ");
                    int did = sc.nextInt();
                    dao.deleteEmployee(did);
                    break;
                case 5:
                    System.out.println("👋 Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }
}

