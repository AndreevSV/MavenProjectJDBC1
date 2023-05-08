import model.City;
import model.Employee;
import repository.CityDao;
import repository.CityDaoImpl;
import repository.EmployeeDao;
import repository.EmployeeDaoImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
    public static void main(String[] args) {
//
//        City city = new City();
//        city.setCityName("Kaluga");
//
        CityDao cityDao = new CityDaoImpl();
//
//        cityDao.addCity(city);

//        cityDao.getCityById(4);

        cityDao.deleteCity(new City(7, "Kalinigrad"));

//        cityDao.updateCity(new City(7, "Kaliningrad"));

//       cityDao.getAllCityes();


//        EmployeeDao employeeDao = new EmployeeDaoImpl();
//
//        Employee employee = new Employee();
//        employee.setId(6);
//        employee.setFirstName("Andrey");
//        employee.setLastName("Sokolov");
//        employee.setGender("male");
//        employee.setAge(31);
//        employee.setCity(new City(4, "Tula"));
//
//        employeeDao.addEmployee(employee);

//        employeeDao.getAllEmployees();

//        employeeDao.getEmployeeById(3);

//        employeeDao.updateEmployee(employee);

//        employeeDao.deleteEmployee(employee);

    }
}