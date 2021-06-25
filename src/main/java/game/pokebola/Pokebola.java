package game.pokebola;

import game.Pokemon;

import java.util.Random;


public class Pokebola {

    protected float getTaxaModificada(Pokemon pokemon) {
        return pokemon.getTaxaDeCaptura();
    }

    protected final int calcularNumeroCaptura(Pokemon pokemon) {
        int hpMax = pokemon.getHpMax();
        int hpAtual = pokemon.getHpAtual();
        float taxaModificada = getTaxaModificada(pokemon);
        float equacaoCaptura = ((3*hpMax - 2*hpAtual)*taxaModificada)/(3*hpMax);
        return Math.min(Math.round(Math.max(equacaoCaptura, 1)), 255);
    }

    public boolean capturar(Pokemon pokemon) {
        Random random = new Random();
        int numeroPokemon = random.nextInt(255) + 1;
        int numeroDaSorte = calcularNumeroCaptura(pokemon);
        System.out.println(numeroDaSorte + " " + numeroPokemon);
        return (numeroDaSorte >= numeroPokemon);
    }

    @Override
    public String toString() {
        return "game.pokebola.Pokebola";
    }
}
