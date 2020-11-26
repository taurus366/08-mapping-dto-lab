package course.springdata.mapping.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String city;
    @NonNull
    private String details;
    @NonNull
    private String country;


}
