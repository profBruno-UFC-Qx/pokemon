package game.pokebola;

import game.Pokemon;

public class CuraPokebola extends AlteraEstadoPokebola{

    @Override
    protected void aplicarEfeito(Pokemon pokemon) {
        System.out.println(pokemon.getNome() + " foi curado");
    }

    @Override
    public String toString() {
        return "game.pokebola.CuraPokebola";
    }
}
