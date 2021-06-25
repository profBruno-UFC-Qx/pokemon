package game.pokebola;

import game.Pokemon;

public class FastPokebola extends AlteraTaxaPokebola {

    @Override
    protected float getTaxaModificada(Pokemon pokemon) {
        int taxaDaEspecie = pokemon.getTaxaDeCaptura();
        if(pokemon.getVelocidade() > 100) {
            return 4*taxaDaEspecie;
        }
        return taxaDaEspecie;
    }

    @Override
    public String toString() {
        return "game.pokebola.FastPokebola";
    }
}
