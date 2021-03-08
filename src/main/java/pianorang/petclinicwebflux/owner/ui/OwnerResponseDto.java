package pianorang.petclinicwebflux.owner.ui;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OwnerResponseDto {
    private String firstName;
    private String lastName;
}
