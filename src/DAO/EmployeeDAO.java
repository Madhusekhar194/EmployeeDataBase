package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import DBConnection.DBConnection;
import Entity.Employee;

public class EmployeeDAO {
   
    public void addEmployee(Employee emp) {
        String sql = "INSERT INTO employees(name, role, salary) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, emp.getName());
            ps.setString(2, emp.getRole());
            ps.setDouble(3, emp.getSalary());
            ps.executeUpdate();
            System.out.println("✅ Employee added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public List<Employee> getEmployees() {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("role"),
                        rs.getDouble("salary")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    
    public void updateEmployee(int id, String role, double salary) {
        String sql = "UPDATE employees SET role=?, salary=? WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, role);
            ps.setDouble(2, salary);
            ps.setInt(3, id);
            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println("✅ Employee updated successfully!");
            else System.out.println("⚠️ Employee not found!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employees WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println("✅ Employee deleted successfully!");
            else System.out.println("⚠️ Employee not found!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

