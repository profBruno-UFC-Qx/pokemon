package game.estados;

import game.model.Pokedex;

import java.util.ArrayDeque;
import java.util.Deque;

public class MenuPrincipalEstado implements Estado{

    private static final String MENU = "[P]okedex\n[M]ochila\n[V]oltar";
    private Deque<String> mensageria;
    private Pokedex pokedex;
    private enum SubEstados {
        RAIZ ,POKEDEX, MOCHILA
    }
    private boolean terminou = false;

    private SubEstados estadoAtual = SubEstados.RAIZ;


    public MenuPrincipalEstado(Pokedex pokedex, Deque<String> mensageria) {
        this.mensageria = mensageria;
        this.pokedex = pokedex;
    }

    @Override
    public void aoEntrar() {
        mensageria.add("Menu Principal\n" + MENU);
        terminou = false;
    }

    @Override
    public void atualizar(String entrada) {
        switch (entrada) {
            case "P":
                estadoAtual = SubEstados.POKEDEX;
                mensageria.add(MENU);
                break;
            case "M":
                mensageria.add(MENU);
                break;
            case "V":
                mensageria.add(MENU);
                terminou = true;
                break;
            default:
                mensageria.add("Opcao invalida\n" + MENU);
                break;
        }
    }

    @Override
    public void aoSair() {
        terminou = true;
    }

    @Override
    public void renderizar() {
        switch (estadoAtual) {
            case POKEDEX:
                System.out.println(pokedex.getPokemons());
                break;
        }

    }

    @Override
    public boolean terminou() {
        return terminou;
    }

    @Override
    public EstadoEnum getProximoEstado() {
        return EstadoEnum.MAPA;
    }
}
