package game.pokebola;

import game.Pokemon;

public class UltraPokebola extends PokebolaAfetaTaxa {

    public UltraPokebola() {
        preco = 800;
    }

    @Override
    protected int getTaxaModificada(Pokemon pokemon) {
        return 2*pokemon.getTaxaDeCaptura();
    }

    @Override
    public String getNome() {
        return "UltraPokebola";
    }

    @Override
    public String getDescricao() {
        return "Possui uma taxa de captura maior que da GreatPokebola.";
    }

}
