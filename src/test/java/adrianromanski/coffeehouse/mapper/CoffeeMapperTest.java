package adrianromanski.coffeehouse.mapper;

import adrianromanski.coffeehouse.domain.drink.Coffee;
import adrianromanski.coffeehouse.domain.drink.enums.CoffeeSize;
import adrianromanski.coffeehouse.domain.drink.enums.Temperature;
import adrianromanski.coffeehouse.model.drink.CoffeeDTO;
import org.junit.jupiter.api.Test;

import static adrianromanski.coffeehouse.domain.drink.enums.CoffeeSize.*;
import static adrianromanski.coffeehouse.domain.drink.enums.Temperature.*;
import static org.junit.jupiter.api.Assertions.*;

class CoffeeMapperTest {

    public static final Double PRICE = BEAST.getBasePrice();
    public static final long ID = 1L;
    public static final String NAME = "Beast Espresso Caramel";
    public static final String SIZE = "Big";
    CoffeeMapper coffeeMapper = CoffeeMapper.INSTANCE;

    @Test
    void coffeeToCoffeeDTO() {
        Coffee coffee = new Coffee();
        coffee.setSize(SIZE);
        coffee.setTakeAway(true);
        coffee.setFinalPrice(PRICE);
        coffee.setId(ID);
        coffee.setName(NAME);
        coffee.setTemperature(HOT);

        CoffeeDTO coffeeDTO = coffeeMapper.coffeeToCoffeeDTO(coffee);

        assertEquals(coffeeDTO.getSize(), SIZE);
        assertEquals(coffeeDTO.getFinalPrice(), PRICE);
        assertEquals(coffeeDTO.getName(), NAME);
        assertEquals(coffeeDTO.getTemperature(), HOT);
        assertEquals(coffeeDTO.getId(), ID);
        assertTrue(coffeeDTO.isTakeAway());

    }

    @Test
    void coffeeDTOToCoffee() {
        CoffeeDTO coffeeDTO = new CoffeeDTO();
        coffeeDTO.setSize(SIZE);
        coffeeDTO.setTakeAway(true);
        coffeeDTO.setFinalPrice(PRICE);
        coffeeDTO.setId(ID);
        coffeeDTO.setName(NAME);
        coffeeDTO.setTemperature(HOT);


        Coffee coffee = coffeeMapper.coffeeDTOToCoffee(coffeeDTO);

        assertEquals(coffee.getSize(), SIZE);
        assertEquals(coffee.getFinalPrice(), PRICE);
        assertEquals(coffee.getName(), NAME);
        assertEquals(coffee.getTemperature(), HOT);
        assertEquals(coffee.getId(), ID);
        assertTrue(coffee.isTakeAway());
    }
}