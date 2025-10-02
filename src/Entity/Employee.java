package Entity;

public class Employee {
    private int id;
    private String name;
    private String role;
    private double salary;

    public Employee(int id, String name, String role, double salary) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.salary = salary;
    }

    public Employee(String name, String role, double salary) {
        this.name = name;
        this.role = role;
        this.salary = salary;
    }

    // Getters & Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getRole() { return role; }
    public double getSalary() { return salary; }
}

