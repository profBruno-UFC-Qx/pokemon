package game.pokebola;

import game.Pokemon;

public abstract class AlteraTaxaPokebola extends Pokebola {

    @Override
    protected abstract float getTaxaModificada(Pokemon pokemon);
}
