package course.springdata.mapping.dto;

import course.springdata.mapping.entity.Employee;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class ManagerDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String city;

    private List<EmployeeDto> employees;

    // derived property
    private int getSubordinatesNumber(){
       return employees.size();
    }

    @Override
    public String toString() {
        return "ManagerDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", employees: =" + getSubordinatesNumber() +
                ", city: " + getCity() +
                 employees.stream().map(EmployeeDto::toString).collect(Collectors.joining("\n")) +
                '}';
    }
}
