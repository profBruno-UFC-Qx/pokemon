package game.pokebola;

import game.Pokemon;

public class FastPokebola extends PokebolaAfetaTaxa {

    public FastPokebola() {
        preco = Integer.MAX_VALUE;
    }

    @Override
    protected int getTaxaModificada(Pokemon pokemon) {
        if(pokemon.getVelocidade() > 100) {
            return pokemon.getTaxaDeCaptura() * 4;
        }
        return pokemon.getTaxaDeCaptura();
    }

    @Override
    public String getNome() {
        return "FastPokebola";
    }

    @Override
    public String getDescricao() {
        return "Facilita a captura de pokemons velozes";
    }

}
