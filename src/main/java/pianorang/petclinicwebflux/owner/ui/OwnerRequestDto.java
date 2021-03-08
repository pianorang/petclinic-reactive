package pianorang.petclinicwebflux.owner.ui;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OwnerRequestDto {
    private String firstName;
    private String lastName;
    private String address;
}
