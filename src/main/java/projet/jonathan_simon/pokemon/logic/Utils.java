package projet.jonathan_simon.pokemon.logic;

import org.springframework.stereotype.Component;

import projet.jonathan_simon.pokemon.entity.Pokemon;

@Component
public class Utils {
    public Pokemon createRandomStat(Pokemon pokemon){ 
        int pvRan = (int) (Math.abs(Math.random() * ((200 - 20) + 20)));
        int attackRan = (int) (Math.abs(Math.random() * ((60 - 30) + 30)));
        int defenseRan = (int) (Math.abs(Math.random() * ((50 - 25) + 25)));
        int pcCalc = pvRan * ((attackRan + defenseRan) / 2);
        pokemon.setAttack(attackRan);
        pokemon.setDefense(defenseRan);
        pokemon.setPv(pvRan);
        pokemon.setPc(pcCalc);
        return pokemon;
    }
}
