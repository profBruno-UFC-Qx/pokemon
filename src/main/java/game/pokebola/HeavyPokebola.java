package game.pokebola;

import game.Pokemon;

public class HeavyPokebola extends PokebolaAfetaTaxa {

    @Override
    protected int getTaxaModificada(Pokemon pokemon) {
        float peso = pokemon.getPeso();
        if(peso < 100) {
            return pokemon.getTaxaDeCaptura() - 20;
        } else if (peso >=100 && peso < 200) {
            return pokemon.getTaxaDeCaptura();
        } else if (peso >=200 && peso < 300) {
            return pokemon.getTaxaDeCaptura() + 20;
        } else {
            return pokemon.getTaxaDeCaptura() + 30;
        }
    }

    @Override
    public String getNome() {
        return "HeavyPokebola";
    }

    @Override
    public String getDescricao() {
        return "Aumenta a chance de capturar pokemons pesados.";
    }

}
