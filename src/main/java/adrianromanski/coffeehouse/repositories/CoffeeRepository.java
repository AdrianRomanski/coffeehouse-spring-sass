package adrianromanski.coffeehouse.repositories;

import adrianromanski.coffeehouse.domain.drink.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
}
