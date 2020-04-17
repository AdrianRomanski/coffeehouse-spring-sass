package adrianromanski.coffeehouse.model.drink;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CoffeeDTO extends DrinkDTO {

    private boolean takeAway;
}
