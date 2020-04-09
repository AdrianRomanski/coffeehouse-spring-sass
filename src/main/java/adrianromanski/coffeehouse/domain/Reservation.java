package adrianromanski.coffeehouse.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
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
