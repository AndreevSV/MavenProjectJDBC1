package repository;

import model.Employee;

import java.util.List;

public interface EmployeeDao {

    void addEmployee(Employee employee);

    Employee getEmployeeById(Integer id);

    List<Employee> getAllEmployees();

    void updateEmployeeCityById(Integer id, Integer city_id);

    void deleteEmployeeById(Integer id);
}