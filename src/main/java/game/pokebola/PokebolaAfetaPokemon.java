package game.pokebola;

import game.Pokemon;

public abstract class PokebolaAfetaPokemon extends Pokebola {

    protected abstract void aplicarEfeito(Pokemon pokemon);

    @Override
    public boolean capturar(Pokemon pokemon) {
        boolean capturou = super.capturar(pokemon);
        if(capturou) {
            aplicarEfeito(pokemon);
        }
        return capturou;
    }
}
