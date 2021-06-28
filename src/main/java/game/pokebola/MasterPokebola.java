package game.pokebola;

import game.Pokemon;

public class MasterPokebola extends Pokebola{

    @Override
    public boolean capturar(Pokemon pokemon) {
        return true;
    }

    @Override
    public String toString() {
        return "MasterPokebola";
    }
}
