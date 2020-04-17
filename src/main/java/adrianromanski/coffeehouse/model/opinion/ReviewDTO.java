package adrianromanski.coffeehouse.model.opinion;

import adrianromanski.coffeehouse.model.person.ClientDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ReviewDTO extends OpinionDTO {

    private ClientDTO clientDTO;
    private Integer rating;
}
