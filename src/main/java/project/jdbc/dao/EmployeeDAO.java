package project.jdbc.dao;

import project.jdbc.model.Employee;

import java.util.List;

public interface EmployeeDAO {

    void createEmployee(Employee employee);

    Employee readeEmployeeById(int id);

    List<Employee> readAllEmployee();

    void updateEmployeeById(Employee employee);

    void deleteEmployeeById(Employee employee);

}
// Забыл создать новую ветку, простите.

