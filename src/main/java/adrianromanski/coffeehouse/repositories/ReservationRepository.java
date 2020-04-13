package adrianromanski.coffeehouse.repositories;

import adrianromanski.coffeehouse.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
