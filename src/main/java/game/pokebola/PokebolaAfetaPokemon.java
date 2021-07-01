package game.pokebola;

import game.Pokemon;

public abstract class PokebolaAfetaPokemon extends Pokebola {

    @Override
    public abstract String getNome();

    @Override
    public abstract String getDescricao();

    protected abstract void aplicarEfeito(Pokemon pokemon);

    @Override
    public final boolean capturar(Pokemon pokemon) {
        boolean capturou = super.capturar(pokemon);
        if(capturou) {
            aplicarEfeito(pokemon);
        }
        return capturou;
    }
}
