package projet.jonathan_simon.pokemon.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import projet.jonathan_simon.pokemon.entity.Pokemon;
import projet.jonathan_simon.pokemon.service.PokemonService;

@Controller
@RequestMapping("/pokemon")
public class PokemonDeleteController {

    private final PokemonService service;

    public PokemonDeleteController(PokemonService service) {
        this.service = service;
    }

    // Page de présentation de la suppression de pokémons en BDD
    @GetMapping("/pokeDelete")
    public String formDelete(Model model) {
        Pokemon pokemonId = new Pokemon();
        // Permet d'afficher dasn le select
        model.addAttribute("pokemons", service.getPokemons());
        model.addAttribute("pokemonId", pokemonId);
        return "pokeDelete";
    }

    // Page de suppression de pokémons en BDD
    @PostMapping("/pokeDelete")
    public String greetingSubmitDelete(@ModelAttribute("pokemonId") Pokemon pokemon) {
        service.deletePokemon(pokemon.getId());
        return "pokeDeleteSuccess";
    }

    // Page d'affichage d'un pokémon en BDD
    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Long id, Model model) {
        Optional<Pokemon> existingItemOptional = service.getPokemonById(id);
        Pokemon pokemon = new Pokemon();
        if (existingItemOptional.isPresent()) {
            pokemon = existingItemOptional.get();
        }
        model.addAttribute("pokemon", pokemon);
        return "pokeDetail";
    }

    // Page de suppresion d'un pokémon en BDD depuis l'affichage unique du pokémon
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        try {
            service.deletePokemon(id);
            return "pokeDeleteSuccess";
        } catch (Exception e) {
            return "Error";
        }
    }
}
