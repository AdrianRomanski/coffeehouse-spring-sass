package adrianromanski.coffeehouse.bootstrap;

import adrianromanski.coffeehouse.config.AppProfiles;
import adrianromanski.coffeehouse.domain.drink.Coffee;
import adrianromanski.coffeehouse.domain.drink.Coffee2;
import adrianromanski.coffeehouse.repositories.Coffee2Repository;
import adrianromanski.coffeehouse.repositories.CoffeeRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
@Profile(AppProfiles.DEV)
@Slf4j
public class InMemCoffeeBootstrap implements CommandLineRunner {

    private final CoffeeRepository coffeeRepository;
    private final Coffee2Repository coffee2Repository;
    private final Resource coffeesResource;
    private final ObjectMapper objectMapper;

    public InMemCoffeeBootstrap(
            CoffeeRepository coffeeRepository,
            Coffee2Repository coffee2Repository,
            @Value("classpath:data/coffee-data.json") Resource coffeesResource,
            ObjectMapper objectMapper) {
        this.coffeeRepository = coffeeRepository;
        this.coffee2Repository = coffee2Repository;
        this.coffeesResource = coffeesResource;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        saveCoffees();
        log.info("Coffees saved!");
        saveCoffees2();
    }

    private void saveCoffees() {
        Coffee frappe = new Coffee();
        frappe.setName("frappe");
        coffeeRepository.save(frappe);

        Coffee latte = new Coffee();
        latte.setName("latte");
        coffeeRepository.save(latte);

        Coffee mocha = new Coffee();
        mocha.setName("mocha");
        coffeeRepository.save(mocha);
    }

    private void saveCoffees2() throws IOException {
        List<? extends Coffee2> coffees2 = readCoffees2();
        coffee2Repository.saveAll(coffees2);
        log.info("Saved Coffee2 objects: {}", coffees2);
    }

    private List<? extends Coffee2> readCoffees2() throws IOException {
        try (InputStream in = coffeesResource.getInputStream()) {
            return objectMapper.readValue(in, new TypeReference<List<Coffee2>>() {
            });
        }
    }
}
