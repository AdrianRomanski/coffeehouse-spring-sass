package adrianromanski.coffeehouse.controllers;

import adrianromanski.coffeehouse.service.CoffeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/coffees")
public class CoffeeController {

    private final CoffeeService coffeeService;

    @RequestMapping({"", "/"})
    public String index(Model model) {
        model.addAttribute("coffeeList", coffeeService.findAll());
        return "coffeeList";
    }

}
