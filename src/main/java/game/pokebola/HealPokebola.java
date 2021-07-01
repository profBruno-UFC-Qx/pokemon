package game.pokebola;

import game.Pokemon;

public class HealPokebola extends PokebolaAfetaPokemon {

    @Override
    protected void aplicarEfeito(Pokemon pokemon) {
        pokemon.setPvAtual(pokemon.getPvMax());
    }

    @Override
    public String getNome() {
        return "HealPokebola";
    }

    @Override
    public String getDescricao() {
        return "Restaura o Pv do pokemon capturado";
    }
}
