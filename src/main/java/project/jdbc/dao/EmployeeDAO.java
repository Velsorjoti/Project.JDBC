package project.jdbc.dao;

import project.jdbc.model.Employee;

import java.util.List;

public interface EmployeeDAO {

    void createEmployee(Employee employee);

    Employee readeEmployeeById(int id);

    List<Employee> readAllEmployee();

    void updateEmployeeById(int id, String name);

    void deleteEmployeeById(int id);

}

