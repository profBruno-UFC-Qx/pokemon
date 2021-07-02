package game.pokebola;

import game.Pokemon;

public class HealPokebola extends PokebolaAfetaPokemon {
    
    public HealPokebola() {
        preco = 300;
    }

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
