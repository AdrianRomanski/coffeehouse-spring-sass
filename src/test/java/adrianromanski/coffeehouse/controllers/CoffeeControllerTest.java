package adrianromanski.coffeehouse.controllers;

import adrianromanski.coffeehouse.model.drink.CoffeeDTO;
import adrianromanski.coffeehouse.service.CoffeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class CoffeeControllerTest {

    @MockBean
    CoffeeService coffeeService;

    @InjectMocks
    CoffeeController coffeeController;

    MockMvc mockMvc;


    @BeforeEach
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(coffeeController).build();
    }

    @Test
    void index() throws Exception {
        // Given
        List<CoffeeDTO> coffees = Arrays.asList(new CoffeeDTO(), new CoffeeDTO(), new CoffeeDTO());

        when(coffeeService.findAll()).thenReturn(coffees);

        mockMvc.perform(get("/coffees"))
                .andExpect(status().isOk())
                .andExpect(view().name("coffeeList"))
                .andExpect(model().attributeExists("coffeeList"));

        verify(coffeeService, times(1)).findAll();


    }
}