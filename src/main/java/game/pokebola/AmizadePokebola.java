package game.pokebola;

import game.Pokemon;

public class AmizadePokebola extends AlteraEstadoPokebola{

    @Override
    protected void aplicarEfeito(Pokemon pokemon) {
        System.out.println(pokemon.getNome() + " ganhou 20 de amizade");
    }

    @Override
    public String toString() {
        return "game.pokebola.AmizadePokebola";
    }

}
