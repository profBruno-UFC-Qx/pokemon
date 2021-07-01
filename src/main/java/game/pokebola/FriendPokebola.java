package game.pokebola;

import game.Pokemon;

public class FriendPokebola extends PokebolaAfetaPokemon {

    @Override
    protected void aplicarEfeito(Pokemon pokemon) {
        pokemon.setNivelDeAmizade(200);
    }

    @Override
    public String getNome() {
        return "FriendBola";
    }

    @Override
    public String getDescricao() {
        return "Eleva o nivel de amizade do pokemon capturado para 200";
    }
}
