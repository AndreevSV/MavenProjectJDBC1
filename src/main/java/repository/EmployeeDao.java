package repository;

import model.Employee;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {
    Connection getConnection() throws SQLException;

    void addEmployee(Employee employee);

    Employee getEmployeeById(Integer id);

    List<Employee> getAllEmployees();

    void updateEmployeeCityById(Integer id, Integer city_id);

    void deleteEmployeeById(Integer id);
}