package game.pokebola;

import game.Pokemon;
public class HealPokebola extends PokebolaAfetaPokemon {

    @Override
    protected void aplicarEfeito(Pokemon pokemon) {
        pokemon.setPvAtual(pokemon.getPvMax());
    }

    @Override
    public String toString() {
        return "HealPokebola";
    }
}
