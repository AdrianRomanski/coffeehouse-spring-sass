package adrianromanski.coffeehouse.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;

@NoArgsConstructor
@Data
public class ReviewDTO extends BaseEntityDTO {

    private LocalDate date;

    @ManyToOne
    private ClientDTO clientDTO;

    private String content;

    @Min(0)
    @Max(5)
    private Integer rating;
}
