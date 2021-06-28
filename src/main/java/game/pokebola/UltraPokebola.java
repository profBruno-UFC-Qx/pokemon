package game.pokebola;

import game.Pokemon;

public class UltraPokebola extends PokebolaAfetaTaxa {

    @Override
    protected int getTaxaModificada(Pokemon pokemon) {
        return 2*pokemon.getTaxaDeCaptura();
    }

    @Override
    public String toString() {
        return "UltraPokebola";
    }
}
