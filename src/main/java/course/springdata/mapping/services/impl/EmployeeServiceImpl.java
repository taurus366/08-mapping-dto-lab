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
    public List<Employee> getAllManagers() {
        return employeeRepo.getManagers();
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
        if (employee.getManager() != null){
            employee.getManager().getSubordinates().add(employee);
        }
        return employeeRepo.save(employee);
    }

    @Override
    @Transactional
    public Employee updateEmployee(Employee employee) {
       Employee existing = getEmployeeById(employee.getId());
        Employee updated = employeeRepo.save(employee);
        // <- -> двупосочен
       if (existing.getManager() != null && !existing.getManager().equals(employee.getManager())){
          existing.getManager().getSubordinates().remove(existing);
       }
       if (updated.getManager() != null && !updated.getManager().equals(existing.getManager())){
           updated.getManager().getSubordinates().add(updated);
       }
        return updated;
    }

    @Override
    @Transactional
    public Employee deleteEmployee(Long id) {
        Employee employeeById = getEmployeeById(id);
        if (employeeById.getManager() != null){
            employeeById.getManager().getSubordinates().remove(employeeById);
        }
        employeeRepo.deleteById(employeeById.getId());
        return employeeById;
    }

    @Override
    public long getEmployeesCount() {


        return employeeRepo.count();
    }
}
