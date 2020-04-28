package adrianromanski.coffeehouse.service;

import adrianromanski.coffeehouse.domain.drink.Coffee;
import adrianromanski.coffeehouse.mapper.CoffeeMapper;
import adrianromanski.coffeehouse.model.drink.CoffeeDTO;
import adrianromanski.coffeehouse.repositories.CoffeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CoffeeServiceTest {

    @Mock
    CoffeeRepository coffeeRepository;

    CoffeeMapper coffeeMapper;

    CoffeeService coffeeService;

    @BeforeEach
    void setUp() {
        coffeeMapper = CoffeeMapper.INSTANCE;
        coffeeService = new CoffeeService(coffeeRepository, coffeeMapper);
    }

    @Test
    void findAll() {
        // given
        List<Coffee> coffeeList = Arrays.asList(new Coffee(), new Coffee(), new Coffee());
        when(coffeeRepository.findAll()).thenReturn(coffeeList);

        // when
        List<CoffeeDTO> actual = coffeeService.findAll();

        verify(coffeeRepository).findAll();
        assertEquals(coffeeList.size(), actual.size());
    }
}