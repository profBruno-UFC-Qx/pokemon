package game.pokebola;

import game.Pokemon;

public class FastPokebola extends PokebolaAfetaTaxa {

    @Override
    protected int getTaxaModificada(Pokemon pokemon) {
        if(pokemon.getVelocidade() > 100) {
            return pokemon.getTaxaDeCaptura() * 4;
        }
        return pokemon.getTaxaDeCaptura();
    }

    @Override
    public String toString() {
        return "FastPokebola";
    }
}
