package adrianromanski.coffeehouse.mapper;

import adrianromanski.coffeehouse.domain.drink.Coffee;
import adrianromanski.coffeehouse.model.drink.CoffeeDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoffeeMapperTest {

    final long id = 1L;
    final String name = "Beast Espresso Caramel";
    final String description = "A coffee description";
    CoffeeMapper coffeeMapper = CoffeeMapper.INSTANCE;

    @Test
    void coffeeToCoffeeDTO() {
        Coffee coffee = new Coffee();
        coffee.setId(id);
        coffee.setName(name);
        coffee.setDescription(description);

        CoffeeDTO coffeeDTO = coffeeMapper.coffeeToCoffeeDTO(coffee);

        assertEquals(name, coffeeDTO.getName());
        assertEquals(id, coffeeDTO.getId());
        assertEquals(description, coffeeDTO.getDescription());
    }

    @Test
    void coffeeDTOToCoffee() {
        CoffeeDTO coffeeDTO = new CoffeeDTO();
        coffeeDTO.setId(id);
        coffeeDTO.setName(name);
        coffeeDTO.setDescription(description);

        Coffee coffee = coffeeMapper.coffeeDTOToCoffee(coffeeDTO);

        assertEquals(description, coffee.getDescription());
        assertEquals(coffee.getName(), name);
        assertEquals(coffee.getId(), id);
    }
}