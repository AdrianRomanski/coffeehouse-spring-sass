package adrianromanski.coffeehouse.domain.opinion;

import adrianromanski.coffeehouse.domain.person.Client;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 *  We will store this one in MongoDB later
 */
@Entity
@NoArgsConstructor
@Data
public class Review extends Opinion {

    @ManyToOne
    private Client client;

    @Min(0)
    @Max(5)
    private Integer rating;

}
