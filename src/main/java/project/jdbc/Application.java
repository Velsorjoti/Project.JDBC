package project.jdbc;

import project.jdbc.dao.CityDAO;
import project.jdbc.dao.CityDAOImpl;
import project.jdbc.dao.EmployeeDAO;
import project.jdbc.dao.EmployeeDAOImpl;
import project.jdbc.model.City;
import project.jdbc.model.Employee;

import java.sql.*;
import java.util.List;

public class Application {

    public static void main(String[] args) throws SQLException {

      final String user = "postgres";
      final String password = "Velveire";
      final String url = "jdbc:postgresql://localhost:5432/skypro";

  /*      try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("SELECT  * FROM employee WHERE id=(?)")) {

            statement.setInt(1,1);

            final ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String fistNameOfEmployee = "Fist_name: " + resultSet.getString("fist_name");
                String lastNameOfEmployee = "Last_name: " + resultSet.getString("last_name");
                String genderOfEmployee = "Gender : " + resultSet.getString("gender");
                String ageOfEmployee = "Age : " + resultSet.getString("age");
                String cityOfEmployee = "City_id :" + resultSet.getString("city_id");

                System.out.println(fistNameOfEmployee);
                System.out.println(lastNameOfEmployee);
                System.out.println(genderOfEmployee);
                System.out.println(ageOfEmployee);
                System.out.println(cityOfEmployee);
            }
        }*/





        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        CityDAO cityDAO = new CityDAOImpl();

//        City sheffield = new City("Sheffield");
//        cityDAO.createCity(sheffield);

        Employee mss = new Employee("Sarah", "Reed", "Female", 46);
        City city1 = cityDAO.readeCityById(5);
        mss.setCity(city1);
        employeeDAO.createEmployee(mss);















 //       Employee mss = new Employee("Sarah", "Reed", "Female", 46, 1);
   //     employeeDAO.createEmployee(mss);

  //      System.out.println(employeeDAO.readeEmployeeById(1));
       /* List<Employee> listik = employeeDAO.readAllEmployee();

        for (Employee employee: listik) {
            System.out.println(employee);
        }
        Employee helen = new Employee(5, "Helen", "Burns", "Female", 13,2);
        employeeDAO.updateEmployeeById(helen);*/
  //      employeeDAO.deleteEmployeeById(employeeDAO.readeEmployeeById(9));








     //   try (Connection connection = DriverManager.getConnection(url, user, password)) {
        //    City city1 = new City(1,"London");
         //   Employee employee1 = new Employee("Sarah", "Reed", "Female", 46, city1 );
           // EmployeeDAO employeeDAO = new EmployeeDAOImpl(connection);
           // employeeDAO.createEmployee(employee1);
       // }

  //      try  (Connection connection = DriverManager.getConnection(url, user, password) ) {
  //          EmployeeDAO employeeDAO = new EmployeeDAOImpl(connection);
  //          System.out.println(employeeDAO.readeEmployeeById(1));
  //      }


  //      try (Connection connection = DriverManager.getConnection(url, user, password)) {
  //          EmployeeDAO employeeDAO = new EmployeeDAOImpl(connection);
  //          List<Employee> employeeList = employeeDAO.readAllEmployee();
  //          for (Employee employee: employeeList) {
  //              System.out.println(employee);
  //          }
  //      }

  //      try (Connection connection = DriverManager.getConnection(url, user, password)) {
  //          EmployeeDAO employeeDAO = new EmployeeDAOImpl(connection);
  //          employeeDAO.updateEmployeeById(2,"Adele");
  //          employeeDAO.updateEmployeeById(2, "Edward");
  //          employeeDAO.updateEmployeeById(4, "Adele");
  //      }

       /* try (Connection connection = DriverManager.getConnection(url, user, password)) {
            EmployeeDAO employeeDAO = new EmployeeDAOImpl(connection);
            employeeDAO.deleteEmployeeById(8);
        }*/

    }
}

// Забыл создать новую ветку, простите.
