package adrianromanski.coffeehouse.controllers;

import adrianromanski.coffeehouse.domain.drink.Coffee;
import adrianromanski.coffeehouse.repositories.CoffeeRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class CoffeeControllerTest {

    CoffeeController coffeeController;

    @Mock
    CoffeeRepository coffeeRepository;

    MockMvc mockMvc;


    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        coffeeController = new CoffeeController(coffeeRepository);

        mockMvc = MockMvcBuilders.standaloneSetup(coffeeController).build();
    }

    @Test
    void index() throws Exception {
        // Given
        List<Coffee> coffees = Arrays.asList(new Coffee(), new Coffee(), new Coffee());

        when(coffeeRepository.findAll()).thenReturn(coffees);

        mockMvc.perform(get("/coffees"))
                .andExpect(status().isOk())
                .andExpect(view().name("coffeesList"))
                .andExpect(model().attributeExists("coffeeList"));

        verify(coffeeRepository, times(1)).findAll();


    }
}