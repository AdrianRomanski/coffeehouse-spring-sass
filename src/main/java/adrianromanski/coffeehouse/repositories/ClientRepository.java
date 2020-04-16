package adrianromanski.coffeehouse.repositories;

import adrianromanski.coffeehouse.domain.person.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
