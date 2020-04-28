package adrianromanski.coffeehouse.model.drink;

import adrianromanski.coffeehouse.model.BaseEntityDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CoffeeDTO extends BaseEntityDTO {

    private String name;
    private String description;
}
