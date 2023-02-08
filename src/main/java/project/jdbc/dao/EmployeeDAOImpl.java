package project.jdbc.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import project.jdbc.config.HibernateSessionFactoryUtil;
import project.jdbc.model.City;
import project.jdbc.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public void createEmployee(Employee employee) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }
    }

    @Override
    public Employee readeEmployeeById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Employee.class, id);
    }

    @Override
    public List<Employee> readAllEmployee() {
        List<Employee> employeeListik = (List<Employee>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Employee ").list();
        return employeeListik;
    }

    @Override
    public void updateEmployeeById(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        }
    }

    @Override
    public void deleteEmployeeById(Employee employee) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        }
    }



    /*
    private Connection connection;

    public EmployeeDAOImpl(Connection connection) {
        this.connection = connection;
    }



      @Override
    public void createEmployee(Employee employee) {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO employee (fist_name, last_name, gender, age, city_id) VALUES ((?), (?), (?), (?), (?));" )) {

            statement.setString(1, employee.getFistName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getGender());
            statement.setInt(4, employee.getAge());
            statement.setInt(5, employee.getCity().getCityid());

            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    @Override
    public Employee readeEmployeeById(int id) {
        Employee employee = new Employee();
        // Формируем запрос к базе с помощью PreparedStatement
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM employee INNER JOIN city ON employee.city_id=city.city_id AND id=(?)")) {

            // Подставляем значение вместо wildcard
            statement.setInt(1, id);

            // Делаем запрос к базе и результат кладем в ResultSet
            ResultSet resultSet = statement.executeQuery();

            // Методом next проверяем есть ли следующий элемент в resultSet
            // и одновременно переходим к нему, если таковой есть
            while(resultSet.next()) {

                // С помощью методов getInt и getString получаем данные из resultSet
                // и присваиваем их полим объекта
                employee.setId(Integer.parseInt(resultSet.getString("id")));
                employee.setFistName(resultSet.getString("fist_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setGender(resultSet.getString("gender"));
                employee.setAge(resultSet.getInt("age"));
                employee.setCity(new City(resultSet.getInt("city_id"),
                        resultSet.getString("city_name")));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }


    @Override
    public List<Employee> readAllEmployee() {
        List<Employee> employeeList = new ArrayList<>();

        try(PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM employee INNER JOIN city ON employee.city_id=city.city_id")) {

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                int id = Integer.parseInt(resultSet.getString("id"));
                String fistName = resultSet.getString("fist_name");
                String lastName = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");
                City city = new City(resultSet.getInt("city_id"),
                        resultSet.getString("city_name"));



                // Создаем объекты на основе полученных данных
                // и укладываем их в итоговый список
                employeeList.add(new Employee(id, fistName, lastName, gender, age, city));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employeeList;

    }

    @Override
    public void updateEmployeeById(int id, String name) {
        try(PreparedStatement statement = connection.prepareStatement(
                "UPDATE employee SET fist_name =(?) WHERE id=(?)")) {

            statement.setInt(2, id);
            statement.setString(1, name);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployeeById(int id) {
            try(PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM employee WHERE id=(?)")) {

                statement.setInt(1, id);
                statement.execute();

            } catch (SQLException e) {
                e.printStackTrace();
            }
    } */
}
