package adrianromanski.coffeehouse.bootstrap;

import adrianromanski.coffeehouse.config.CoffeehouseProfile;
import adrianromanski.coffeehouse.domain.drink.Coffee;
import adrianromanski.coffeehouse.repositories.CoffeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Profile(CoffeehouseProfile.H2)
@Slf4j
public class InMemCoffeeBootstrap implements CommandLineRunner {

    private final CoffeeRepository coffeeRepository;

    @Override
    public void run(String... args) throws Exception {
        saveCoffees();
        log.info("Coffees saved!");
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
}
