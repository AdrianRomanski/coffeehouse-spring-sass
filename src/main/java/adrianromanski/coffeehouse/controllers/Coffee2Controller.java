package adrianromanski.coffeehouse.controllers;

import adrianromanski.coffeehouse.domain.drink.Coffee2;
import adrianromanski.coffeehouse.repositories.Coffee2Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/coffees2")
public class Coffee2Controller {

    private final Coffee2Repository coffee2Repository;

    @GetMapping
    public String listCoffees(Model model) {
        Iterable<Coffee2> coffees2 = coffee2Repository.findAll();
        model.addAttribute("coffeeList", coffees2);
        return "coffees2List";
    }

}
