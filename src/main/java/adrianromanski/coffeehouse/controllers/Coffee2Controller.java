package adrianromanski.coffeehouse.controllers;

import adrianromanski.coffeehouse.domain.drink.Coffee;
import adrianromanski.coffeehouse.repositories.CoffeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/coffees2")
public class Coffee2Controller {

    private final CoffeeRepository coffeeRepository;

    @GetMapping
    public String listCoffees(Model model) {
        Iterable<Coffee> coffees2 = coffeeRepository.findAll();
        model.addAttribute("coffeeList", coffees2);
        return "coffeeList";
    }

}
