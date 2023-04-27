import model.Employee;
import repository.EmployeeDao;
import repository.EmployeeDaoImpl;

public class Application {
    public static void main(String[] args) {
//        final String user = "postgres";
//        final String password = "****";
//        final String url = "jdbc:postgresql://localhost:5432/skypro";
//
//        try (final Connection connection = DriverManager.getConnection(url, user, password);
//             final PreparedStatement statement = connection.prepareStatement("SELECT id, first_name, last_name, gender, age, city_name FROM employee LEFT JOIN city ON city.city_id = employee.city_id WHERE id = (?) ORDER BY id")) {
//            statement.setInt(1, 4);
//
//            final ResultSet resultSet = statement.executeQuery();
//
//            while (resultSet.next()) {
//                Integer id = resultSet.getInt(1);
//                String first_name = resultSet.getString(2);
//                String last_name = resultSet.getString(3);
//                String gender = resultSet.getString(4);
//                Integer age = resultSet.getInt(5);
//                String city = resultSet.getString(6);
//                System.out.println(id + " " + first_name + " " + last_name + " " + gender + " " + age + " " + city);
//            }
//
//        } catch (SQLException e) {
//            e.getCause();
//        }
        EmployeeDao employeeDao = new EmployeeDaoImpl();

        Employee employee = new Employee();

        employee.setFirst_name("Slava");
        employee.setLast_name("Kaplan");
        employee.setGender("male");
        employee.setAge(45);
        employee.setCity_id(1);

//        employeeDao.addEmployee(employee);

//        System.out.println(employeeDao.getAllEmployees());

//        System.out.println(employeeDao.getEmployeeById(3));

//        employeeDao.updateEmployeeCityById(1, 3);

        employeeDao.deleteEmployeeById(8);

    }
}