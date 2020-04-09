package adrianromanski.coffeehouse.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(exclude = {"reservations"})
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Client  extends Person {

    @Email
    private String email;

    private String telephoneNumber;

    @OneToMany(mappedBy = "client", cascade = CascadeType.PERSIST)
    private List<Reservation> reservations = new ArrayList<>();

}
