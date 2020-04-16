package adrianromanski.coffeehouse.domain.person;

import adrianromanski.coffeehouse.domain.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.MappedSuperclass;


@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class Person extends BaseEntity {

    private String firstName;
    private String lastName;

}
