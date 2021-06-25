package game.pokebola;

import game.Pokemon;

public class GreatPokebola extends AlteraTaxaPokebola {

    @Override
    protected float getTaxaModificada(Pokemon pokemon) {
        return 1.5f*pokemon.getTaxaDeCaptura();
    }

    @Override
    public String toString() {
        return "game.pokebola.GreatPokebola";
    }


}
