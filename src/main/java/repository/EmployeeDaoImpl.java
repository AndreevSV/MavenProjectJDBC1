package repository;

import lombok.RequiredArgsConstructor;
import model.Employee;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@RequiredArgsConstructor
public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public Connection getConnection() throws SQLException {
        Properties properties = new Properties();
        try (InputStream inputStream = getClass().getResourceAsStream("/application.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String url = properties.getProperty("path.to.database");
        String username = properties.getProperty("username.to.database");
        String password = properties.getProperty("password.to.database");

        return DriverManager.getConnection(url, username, password);
    }

    @Override
    public void addEmployee(Employee employee) {

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO employee (first_name, last_name, gender, age, city_id) VALUES (?,?,?,?,?) RETURNING id")) {
            preparedStatement.setString(1, employee.getFirst_name());
            preparedStatement.setString(2, employee.getLast_name());
            preparedStatement.setString(3, employee.getGender());
            preparedStatement.setInt(4, employee.getAge());
            preparedStatement.setInt(5, employee.getCity_id());

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                employee.setId(resultSet.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        Employee employee = new Employee();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee WHERE id = (?)")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employee.setId(resultSet.getInt("id"));
                employee.setFirst_name(resultSet.getString("first_name"));
                employee.setLast_name(resultSet.getString("last_name"));
                employee.setGender(resultSet.getString("gender"));
                employee.setAge(resultSet.getInt("age"));
                employee.setCity_id(resultSet.getInt("city_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {

        List<Employee> employeeList = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee ORDER BY id")
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = Integer.parseInt(resultSet.getString(1));
                String first_name = resultSet.getString(2);
                String last_name = resultSet.getString(3);
                String gender = resultSet.getString(4);
                Integer age = Integer.parseInt(resultSet.getString(5));
                Integer city_id = resultSet.getInt(6);

                employeeList.add(new Employee(id, first_name, last_name, gender, age, city_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public void updateEmployeeCityById(Integer id, Integer city_id) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE employee SET city_id = city.city_id FROM city WHERE employee.id = (?) AND city.city_id = (?)")
        ) {
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, city_id);

            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM employee WHERE id = (?)")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
