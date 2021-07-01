package game.pokebola;

import game.Pokemon;

public class GreatPokebola extends PokebolaAfetaTaxa {

    @Override
    protected int getTaxaModificada(Pokemon pokemon) {
        return Math.round(1.5f*pokemon.getTaxaDeCaptura());
    }

    @Override
    public String getNome() {
        return "GreatPokebola";
    }

    @Override
    public String getDescricao() {
        return "Possui uma taxa de captura maior que de uma Pokebola.";
    }
}
