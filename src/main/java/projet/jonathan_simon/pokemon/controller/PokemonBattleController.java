package projet.jonathan_simon.pokemon.controller;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import projet.jonathan_simon.pokemon.entity.Pokemon;
import projet.jonathan_simon.pokemon.service.PokemonService;


@Controller
@RequestMapping("/pokemon")
public class PokemonBattleController {
    
    private final PokemonService service;

    public PokemonBattleController(PokemonService service) {
        this.service = service;
    }
    
    // Page de combat de pokémons
    @GetMapping("/battle")
    public String formFight(Model model) {
        Pokemon pokemonId = new Pokemon();
        // Permet d'afficher dasn le select
        model.addAttribute("pokemons", service.getPokemons());
        model.addAttribute("pokemonId", pokemonId);
        return "battle";
    }

    // Page de combat de pokémons
    @PostMapping("/battle")
    public String greetingSubmitFight(@ModelAttribute("pokemonId") Pokemon pokemonA, Model model) {
        Optional<Pokemon> pokemonAttaquant = service.getPokemonById(pokemonA.getId());
        Random r = new Random();
        List<Pokemon> pokemonsList = service.getPokemons();
        int defenserPosition = pokemonsList.size();
        int position = r.nextInt(defenserPosition);
        Long defenserId = pokemonsList.get(position).getId();
        Optional<Pokemon> pokemonDefenseur = service.getPokemonById(defenserId);
        Pokemon pokemonD = new Pokemon();
        if (pokemonAttaquant.isPresent()) {
            pokemonA = pokemonAttaquant.get();
        }
        if (pokemonDefenseur.isPresent()) {
            pokemonD = pokemonDefenseur.get();
        }
        model.addAttribute("pokemonAttaquant", pokemonA);
        model.addAttribute("pokemonDefenseur", pokemonD);

        return "battle2";
    }

    // Page de combat de pokémons
    @GetMapping("/battle2")
    public String formFight2(@RequestParam("pokemonAttaquant") Pokemon pokemonA,
            @RequestParam("pokemonDefenseur") Pokemon pokemonD, Model model) {

        model.addAttribute("pokemonAttaquant", pokemonA);
        model.addAttribute("pokemonDefenseur", pokemonD);
        return "battle2";
    }

    // Page de combat de pokémons
    @PostMapping("/battle2")
    public String greetingSubmitFight2(@RequestParam("pokemonAttaquant") Pokemon pokemonA,
            @RequestParam("pokemonDefenseur") Pokemon pokemonD, Model model) {

        String resultatCombat = pokemonA.Fight(pokemonA, pokemonD);

        model.addAttribute("resultatCombat", resultatCombat);
        model.addAttribute("pokemonAttaquant", pokemonA);
        model.addAttribute("pokemonDefenseur", pokemonD);

        return "battle3";
    }

    // Page de combat de pokémons
    @GetMapping("/battle3")
    public String formFight3(@RequestParam("pokemonAttaquant") Long pokemonAttaquantId,
            @RequestParam("pokemonDefenseur") Long pokemonDefenseurId,
            @RequestParam("resultCombat") String resultCombat, Model model) {
        Optional<Pokemon> pokemonAttaquant = service.getPokemonById(pokemonAttaquantId);
        Optional<Pokemon> pokemonDefenseur = service.getPokemonById(pokemonDefenseurId);
        model.addAttribute("resultatCombat", resultCombat);

        if (pokemonAttaquant.isPresent() && pokemonDefenseur.isPresent()) {
            Pokemon pokemonA = pokemonAttaquant.get();
            Pokemon pokemonD = pokemonDefenseur.get();

            model.addAttribute("pokemonAttaquant", pokemonA);
            model.addAttribute("pokemonDefenseur", pokemonD);

            return "battle3";
        } else {
            // Gérer les cas où les Pokémon ne peuvent pas être trouvés
            return "redirect:/erreur"; // rediriger vers une page d'erreur par exemple
        }
    }
}
