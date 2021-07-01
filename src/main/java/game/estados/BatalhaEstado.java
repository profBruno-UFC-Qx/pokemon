package game.estados;

import game.BancoDePokemon;
import game.Pokemon;
import game.model.PokedexEventos;
import game.pokebola.Pokebola;

import java.util.Deque;
import java.util.List;


public class BatalhaEstado implements Estado, PokedexEventos {

    private boolean emBatalha;
    private Pokemon pokemon ;
    private PokedexEventos observador;
    private List<Pokebola> inventario;
    private Deque<String> mensageria;
    private static final String MENU = "[C]orrer!\n[P]okebola";

    public BatalhaEstado(List<Pokebola> inventario, PokedexEventos observadorPokedex, Deque<String> mensageria) {
        this.inventario = inventario;
        this.mensageria = mensageria;
        this.observador = observadorPokedex;
    }

    @Override
    public void aoEntrar() {
        pokemon = BancoDePokemon.getRandomPokemon();
        mensageria.push("Apareceu um "
                + pokemon
                + " selvagem!\n" + MENU);
        aoVerPokemon(pokemon);
        emBatalha = true;
    }

    @Override
    public void atualizar(String entrada) {
        switch (entrada) {
            case "C":
                if (correr()) {
                    mensageria.push("Ufa. Vc escapou.");
                }
                break;
            case "P":
                if (inventario.isEmpty()) {
                    mensageria.push("Voce nao tem mais pokebolas \n" + MENU);
                } else {
                    Pokebola pokebola = inventario.remove(0);
                    String mensagem = "Voce usou uma " + pokebola.getNome() + " e ";
                    if (pokebola.capturar(pokemon)) {
                        mensageria.push(mensagem + " capturou um " + pokemon);
                        aoCapturar(pokemon);
                        emBatalha = false;
                    } else {
                        mensageria.push(mensagem + "ele quebrou sua " + pokebola.getNome() + "\n" + MENU);
                    }
                }
                break;
            default:
                mensageria.add("Opcao invalida\n" + MENU);
        }
    }

    public boolean correr() {
        emBatalha = false;
        return true;
    }

    @Override
    public void aoSair() {
        emBatalha = false;
    }

    @Override
    public void renderizar() {

    }

    @Override
    public boolean terminou() {
        return !emBatalha;
    }

    @Override
    public EstadoEnum getProximoEstado() {
        return EstadoEnum.MAPA;
    }

    @Override
    public void aoCapturar(Pokemon pokemon) {
        observador.aoCapturar(pokemon);
    }

    @Override
    public void aoVerPokemon(Pokemon pokemon) {
        observador.aoVerPokemon(pokemon);
    }
}
