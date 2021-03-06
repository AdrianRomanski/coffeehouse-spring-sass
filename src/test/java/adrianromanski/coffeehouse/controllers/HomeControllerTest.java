package adrianromanski.coffeehouse.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class HomeControllerTest {


    HomeController homeController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        homeController = new HomeController();

        mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
    }

    @Test
    void home() throws Exception {
        mockMvc.perform(get("/coffee-paradise"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"));
    }
}