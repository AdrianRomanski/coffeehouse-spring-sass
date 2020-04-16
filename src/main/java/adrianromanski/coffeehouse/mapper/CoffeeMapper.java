package adrianromanski.coffeehouse.mapper;

import adrianromanski.coffeehouse.domain.drink.Coffee;
import adrianromanski.coffeehouse.model.drink.CoffeeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CoffeeMapper {

    CoffeeMapper INSTANCE = Mappers.getMapper(CoffeeMapper.class);

    CoffeeDTO coffeeToCoffeeDTO(Coffee coffee);

    Coffee coffeeDTOToCoffee(CoffeeDTO coffeeDTO);
}
