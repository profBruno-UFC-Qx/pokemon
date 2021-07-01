package game.pokebola;

import game.Pokemon;

public class MasterPokebola extends Pokebola {

    @Override
    public String getNome() {
        return "MasterPokebola";
    }

    @Override
    public String getDescricao() {
        return "Sempre captura o pokemon alvo.";
    }

    @Override
    public boolean capturar(Pokemon pokemon) {
        return true;
    }

}
