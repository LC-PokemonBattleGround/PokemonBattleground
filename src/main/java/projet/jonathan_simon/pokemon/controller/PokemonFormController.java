package projet.jonathan_simon.pokemon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import projet.jonathan_simon.pokemon.entity.Pokemon;
import projet.jonathan_simon.pokemon.service.PokemonFormService;
import projet.jonathan_simon.pokemon.service.PokemonService;

@Controller
@RequestMapping("/pokemon")
public class PokemonFormController {

    private final PokemonService service;
    private final PokemonFormService pokemonFormService;

    public PokemonFormController(PokemonService service, PokemonFormService pokemonFormService) {
        this.service = service;
        this.pokemonFormService = pokemonFormService;
    }
    // Page de présentation de la création de pokémons en BDD
    @GetMapping("/pokeForm")
    public String form(Model model) {
        Pokemon pokemon = new Pokemon();
        model.addAttribute("pokemon", pokemon);
        return "pokeForm";
    }

    // Page de création de pokémons en BDD
    @PostMapping("/pokeForm")
    public String greetingSubmit(Pokemon pokemon) {
        pokemon = pokemonFormService.createRandomStat(pokemon);
        service.savePokemon(pokemon);
        return "pokeSucces";
    }
}
