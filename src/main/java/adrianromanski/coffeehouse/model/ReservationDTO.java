package adrianromanski.coffeehouse.model;

import adrianromanski.coffeehouse.model.person.ClientDTO;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ReservationDTO extends BaseEntityDTO {

    private LocalDate dateOfReservation;
    private LocalDate dateOfCreation;
    private Long numberOfPeople;
    private String place;
    private ClientDTO clientDTO;
}
