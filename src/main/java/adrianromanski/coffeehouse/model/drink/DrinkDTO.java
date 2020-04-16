package adrianromanski.coffeehouse.model.drink;

import adrianromanski.coffeehouse.domain.drink.enums.Temperature;
import adrianromanski.coffeehouse.model.BaseEntityDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public class DrinkDTO extends BaseEntityDTO  {

    private String name;
    private Double finalPrice;
    private Temperature temperature;
}
