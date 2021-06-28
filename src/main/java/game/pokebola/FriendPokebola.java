package game.pokebola;

import game.Pokemon;

public class FriendPokebola extends PokebolaAfetaPokemon {
    @Override
    protected void aplicarEfeito(Pokemon pokemon) {
        pokemon.setNivelDeAmizade(200);
    }

    @Override
    public String toString() {
        return "FriendPokebola";
    }
}
