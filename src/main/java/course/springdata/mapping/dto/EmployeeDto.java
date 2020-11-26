package course.springdata.mapping.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class EmployeeDto {

    private Long id;

    private String firstName;

    private String lastName;

    private double salary;

    private LocalDate birthday;

    private String addressCountry;

    private String city;

    private String managerLastName;

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "   -" + id +
                ":'" + firstName + '\'' +
                " " + lastName + '\'' +
                ", salary: " + salary +
                ", birthday=" + birthday +
                "city" + getCity() +
                ", Manager" + managerLastName +
                ", addressCountry='" + addressCountry + '\'' +
                '}';
    }
}
