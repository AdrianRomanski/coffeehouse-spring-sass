package adrianromanski.coffeehouse.model.drink;

import adrianromanski.coffeehouse.domain.drink.enums.CoffeeSize;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CoffeeDTO extends DrinkDTO {

    private CoffeeSize coffeeSize;
    private boolean takeAway;
}
