package adrianromanski.coffeehouse.controllers;

import adrianromanski.coffeehouse.repositories.CoffeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/coffees")
public class CoffeeController {

    private final CoffeeRepository coffeeRepository;

    @RequestMapping({"", "/"})
    public String index(Model model) {
        model.addAttribute("coffeeList", coffeeRepository.findAll());
        return "coffeesList";
    }

}
