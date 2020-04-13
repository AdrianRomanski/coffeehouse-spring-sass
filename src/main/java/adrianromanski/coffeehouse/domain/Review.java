package adrianromanski.coffeehouse.domain;

import adrianromanski.coffeehouse.model.BaseEntityDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
public class Review extends BaseEntityDTO {

    private LocalDate date;

    @ManyToOne
    private Client client;

    private String content;

    @Min(0)
    @Max(5)
    private Integer rating;

}
