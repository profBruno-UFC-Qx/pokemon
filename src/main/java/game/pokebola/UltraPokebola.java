package game.pokebola;

import game.Pokemon;

public class UltraPokebola extends AlteraTaxaPokebola {

    @Override
    protected float getTaxaModificada(Pokemon pokemon) {
        return 2*pokemon.getTaxaDeCaptura();
    }

    @Override
    public String toString() {
        return "UltraPokebola";
    }
}
