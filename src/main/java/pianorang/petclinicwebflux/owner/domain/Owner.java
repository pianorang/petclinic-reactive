package pianorang.petclinicwebflux.owner.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.HashSet;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "owners")
public class Owner {
    @Id
    private Long id;

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String telephone;

}
