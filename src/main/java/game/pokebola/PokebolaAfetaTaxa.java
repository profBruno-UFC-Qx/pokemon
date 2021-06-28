package game.pokebola;

import game.Pokemon;

public abstract class PokebolaAfetaTaxa extends Pokebola {

    @Override
    protected abstract int getTaxaModificada(Pokemon pokemon);
}
