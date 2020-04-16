package adrianromanski.coffeehouse.domain.drink;

import adrianromanski.coffeehouse.domain.drink.enums.CoffeeSize;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Coffee extends Drink {

    private CoffeeSize coffeeSize;
    private boolean takeAway;

}
