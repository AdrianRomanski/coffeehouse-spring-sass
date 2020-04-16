package adrianromanski.coffeehouse.domain.person;

import adrianromanski.coffeehouse.domain.Reservation;
import adrianromanski.coffeehouse.domain.Review;
import adrianromanski.coffeehouse.domain.person.Person;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
public class Client  extends Person {

    @Email
    private String email;

    private String telephoneNumber;

    @OneToMany(mappedBy = "client", cascade = CascadeType.PERSIST)
    private List<Reservation> reservations = new ArrayList<>();

    @OneToMany(mappedBy = "client", cascade = CascadeType.PERSIST)
    private List<Review> reviews = new ArrayList<>();

}
