package game.pokebola;

import game.Pokemon;
import game.model.Item;

import java.util.Random;


public class Pokebola implements Comparable<Pokebola>, Item {

    protected int preco = 200;

    protected int getTaxaModificada(Pokemon pokemon) {
        return pokemon.getTaxaDeCaptura();
    }

    protected final int calcularNumeroCaptura(Pokemon pokemon) {
        int pvMax = pokemon.getPvMax();
        int pvAtual = pokemon.getPvAtual();
        int taxaModificada = getTaxaModificada(pokemon);
        int equacaoCaptura = ((3*pvMax - 2*pvAtual)*taxaModificada)/(3*pvMax);
        return Math.min(Math.max(equacaoCaptura, 1), 255);
    }

    public boolean capturar(Pokemon pokemon) {
        Random random = new Random();
        int numeroPokemon = random.nextInt(255) + 1;
        int numeroDaSorte = calcularNumeroCaptura(pokemon);
        //System.out.print( "("+ numeroDaSorte + " > " + numeroPokemon + "?) ");
        return (numeroDaSorte >= numeroPokemon);
    }

    public int getPreco() {
        return preco;
    }

    @Override
    public int compareTo(Pokebola pokebola) {
        int resultado = preco - pokebola.getPreco();
        if (resultado == 0) {
            return getNome().compareTo(pokebola.getNome());
        } else {
            return resultado;
        }
    }

    @Override
    public String getNome() {
        return "Pokebola";
    }

    @Override
    public String getDescricao() {
        return "Pokebola mais simples do jogo.";
    }
}
