package adrianromanski.coffeehouse.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ClientDTO extends PersonDTO {

    private String email;
    private String telephoneNumber;
    private List<ReservationDTO> reservationsDTO = new ArrayList<>();
    private List<ReviewDTO> reviewsDTO = new ArrayList<>();
}
