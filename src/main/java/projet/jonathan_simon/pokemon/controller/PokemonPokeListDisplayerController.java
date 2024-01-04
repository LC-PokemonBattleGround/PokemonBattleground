package projet.jonathan_simon.pokemon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import projet.jonathan_simon.pokemon.service.PokemonService;

@Controller
@RequestMapping("/pokemon")
public class PokemonPokeListDisplayerController {

    private final PokemonService service;

    public PokemonPokeListDisplayerController(PokemonService service) {
        this.service = service;
    }

    // Page de présentation de tous les pokémons en BDD
    @GetMapping(value = "/pokemons")
    public String pokemons(Model model) {
        model.addAttribute("pokemons", service.getPokemons());
        return "pokeList";
    }
}
