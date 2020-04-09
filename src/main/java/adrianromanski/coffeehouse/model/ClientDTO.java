package adrianromanski.coffeehouse.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO extends PersonDTO {

    private String email;
    private String telephoneNumber;
    private List<ReservationDTO> reservationsDTO = new ArrayList<>();
}
