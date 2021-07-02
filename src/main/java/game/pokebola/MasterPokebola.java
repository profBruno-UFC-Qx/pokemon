package game.pokebola;

import game.Pokemon;

public class MasterPokebola extends Pokebola {

    public MasterPokebola() {
        preco = Integer.MAX_VALUE;
    }

    @Override
    public boolean capturar(Pokemon pokemon) {
        return true;
    }

    @Override
    public String getNome() {
        return "MasterPokebola";
    }

    @Override
    public String getDescricao() {
        return "Sempre captura o pokemon alvo.";
    }
}
