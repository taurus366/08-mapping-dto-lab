package course.springdata.mapping.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressDto {
    private Long id;

    private String city;

    private String details;

    private String country;
}
