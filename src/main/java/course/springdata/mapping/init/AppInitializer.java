package course.springdata.mapping.init;

import course.springdata.mapping.dto.EmployeeDto;
import course.springdata.mapping.entity.Address;
import course.springdata.mapping.entity.Employee;
import course.springdata.mapping.services.AddressService;
import course.springdata.mapping.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class AppInitializer implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AddressService addressService;

    @Override
    public void run(String... args) throws Exception {
        ModelMapper mapper = new ModelMapper();

        // 1.  Create address and employee and map it to EmployeeDto
        Address address1 = new Address("Sofia","Graf Ignatiev 50","Bulgaria");
      address1 =  addressService.addAddress(address1);
        Employee employee1 = new Employee("Ivan","Petrov",3500, LocalDate.of(1981, 5, 12),address1);
      employee1 =  employeeService.addEmployee(employee1);

        EmployeeDto employeeDto = mapper.map(employee1, EmployeeDto.class);

        System.out.printf("EmployeeDto: %s\n",employeeDto);


    }
}
