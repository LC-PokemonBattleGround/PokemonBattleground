package projet.jonathan_simon.pokemon.service;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import lombok.Data;
import projet.jonathan_simon.pokemon.entity.Pokemon;

@Data
@Service
public class PokemonBattleService {
    
    private final PokemonService service;

    public long choseRandomPokemonDefenserId(){
        Random r = new Random();
        List<Pokemon> pokemonsList = service.getPokemons();
        int defenserPosition = pokemonsList.size();
        int position = r.nextInt(defenserPosition);
        Long defenserId = pokemonsList.get(position).getId();
        return defenserId;
    }
}
