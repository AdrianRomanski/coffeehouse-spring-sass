package adrianromanski.coffeehouse.domain.drink;

import adrianromanski.coffeehouse.domain.BaseEntity;
import adrianromanski.coffeehouse.domain.drink.enums.Temperature;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public class Drink extends BaseEntity {

    private String name;
    private Double finalPrice;
    private Temperature temperature;
}
