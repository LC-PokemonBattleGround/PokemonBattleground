package projet.jonathan_simon.pokemon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import projet.jonathan_simon.pokemon.service.PokemonService;

@Controller
@RequestMapping("/pokemon")
public class PokemonHomePageDisplayerController {

    private final PokemonService service;

    public PokemonHomePageDisplayerController(PokemonService service) {
        this.service = service;
    }

    // Page d'accueil de notre site
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("index", service.getPokemons());
        return "index";
    }
}
