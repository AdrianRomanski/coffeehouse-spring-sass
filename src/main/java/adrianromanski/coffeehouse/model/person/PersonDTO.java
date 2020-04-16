package adrianromanski.coffeehouse.model.person;

import adrianromanski.coffeehouse.model.BaseEntityDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class PersonDTO extends BaseEntityDTO {

    private String firstName;
    private String lastName;
}
