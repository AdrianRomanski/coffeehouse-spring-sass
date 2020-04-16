package adrianromanski.coffeehouse.domain;

import adrianromanski.coffeehouse.domain.person.Client;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
public class Reservation extends BaseEntity{

    private LocalDate dateOfReservation;
    private LocalDate dateOfCreation;
    private Long numberOfPeople;
    private String place;

    @ManyToOne
    private Client client;
}
