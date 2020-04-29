package adrianromanski.coffeehouse.service;

import adrianromanski.coffeehouse.mapper.CoffeeMapper;
import adrianromanski.coffeehouse.model.drink.CoffeeDTO;
import adrianromanski.coffeehouse.repositories.CoffeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CoffeeService {

   private final CoffeeRepository coffeeRepository;
   private final CoffeeMapper coffeeMapper;

   public List<CoffeeDTO> findAll() {
      return coffeeRepository.findAll()
              .stream()
              .map(coffeeMapper::coffeeToCoffeeDTO)
              .collect(Collectors.toList());
   }
}
