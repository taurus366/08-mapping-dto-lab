package course.springdata.mapping.services.impl;

import course.springdata.mapping.dao.EmployeeRepository;
import course.springdata.mapping.entity.Employee;
import course.springdata.mapping.exception.NoneExistingEntityException;
import course.springdata.mapping.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private final EmployeeRepository employeeRepo;

    public EmployeeServiceImpl(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }


    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepo.findById(id).orElseThrow(()-> new NoneExistingEntityException(
                String.format("Employee with ID=%s does not exists.",id))
        );
    }

    @Override
    @Transactional
    public Employee addEmployee(Employee employee) {
        employee.setId(null);
        return employeeRepo.save(employee);
    }

    @Override
    @Transactional
    public Employee updateEmployee(Employee employee) {
        getEmployeeById(employee.getId());
        return employeeRepo.save(employee);
    }

    @Override
    @Transactional
    public Employee deleteEmployee(Long id) {
        Employee employeeById = getEmployeeById(id);
        employeeRepo.deleteById(employeeById.getId());
        return employeeById;
    }

    @Override
    public long getEmployeesCount() {
        return employeeRepo.count();
    }
}
