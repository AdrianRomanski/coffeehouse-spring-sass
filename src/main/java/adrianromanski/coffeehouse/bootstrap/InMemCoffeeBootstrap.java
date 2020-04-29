package adrianromanski.coffeehouse.bootstrap;

import adrianromanski.coffeehouse.config.AppProfiles;
import adrianromanski.coffeehouse.domain.drink.Coffee;
import adrianromanski.coffeehouse.repositories.CoffeeRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
@Profile(AppProfiles.DEV)
@Slf4j
public class InMemCoffeeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final CoffeeRepository coffeeRepository;
    private final Resource coffeesResource;
    private final ObjectMapper objectMapper;

    public InMemCoffeeBootstrap(
            CoffeeRepository coffeeRepository,
            @Value("classpath:data/coffee-data.json") Resource coffeesResource,
            ObjectMapper objectMapper) {
        this.coffeeRepository = coffeeRepository;
        this.coffeesResource = coffeesResource;
        this.objectMapper = objectMapper;
    }

    @SneakyThrows
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.info("Coffees saved!");
        saveCoffees();
    }


    private void saveCoffees() throws IOException {
        List<? extends Coffee> coffees2 = readCoffees();
        coffeeRepository.saveAll(coffees2);
        log.info("Saved Coffee2 objects: {}", coffees2);
    }

    private List<? extends Coffee> readCoffees() throws IOException {
        try (InputStream in = coffeesResource.getInputStream()) {
            return objectMapper.readValue(in, new TypeReference<List<Coffee>>() {
            });
        }
    }

}
