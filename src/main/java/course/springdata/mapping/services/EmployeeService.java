package course.springdata.mapping.services;

import course.springdata.mapping.entity.Employee;


import java.util.List;


public interface EmployeeService {

    List<Employee> getAllEmployees();

    List<Employee> getAllManagers();

    Employee getEmployeeById(Long id);

    Employee addEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    Employee deleteEmployee(Long id);

    long getEmployeesCount();

}
