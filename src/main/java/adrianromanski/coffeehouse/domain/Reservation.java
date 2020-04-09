package adrianromanski.coffeehouse.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;

@EqualsAndHashCode(exclude = {"client"})
@Data
@AllArgsConstructor
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
