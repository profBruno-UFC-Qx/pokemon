package game.estados;

import game.Mapa;
import game.model.Ator;
import game.model.Posicionavel;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

public class MapaEstado implements Estado {

    private static final String MENU = "pf -> Andar Frente \npt -> Andar para Tras \ndir -> Andar para a direita \nesq -> Andar para esquerda\nM -> Menu";
    private Mapa mapa;
    private Ator treinador;
    private Deque<String> mensageria;
    private boolean terminou = false;
    private EstadoEnum proximoEstado = EstadoEnum.MAPA;

    private static final int MAX_X = 20;
    private static final int MAX_Y = 5;

    public MapaEstado(Ator ator, Deque<String> mensageria) {
        mapa = new Mapa(MAX_X, MAX_Y);
        this.mensageria = mensageria;
        treinador = ator;
    }

    @Override
    public void aoEntrar() {
        mensageria.push(MENU);
        renderizar();
        terminou = false;
        proximoEstado = EstadoEnum.MAPA;
    }

    @Override
    public void atualizar(String entrada) {
        boolean moveu = true;
        switch (entrada) {
            case "pf":
                treinador.move(Posicionavel.Direcao.CIMA);
                break;
            case "pt":
                treinador.move(Posicionavel.Direcao.BAIXO);
                break;
            case "dir":
                treinador.move(Posicionavel.Direcao.DIREITA);
                break;
            case "esq":
                treinador.move(Posicionavel.Direcao.ESQUERDA);
                break;
            case "M":
                setProximoEstado(EstadoEnum.MENU_PRINCIPAL);
                moveu = false;
                break;
            default:
                mensageria.add("Opcao invalida\n" + MENU);
                moveu = false;
        }
        if(moveu && achouPokemon()) {
            setProximoEstado(EstadoEnum.BATALHA);
        }
    }

    private void setProximoEstado(EstadoEnum proximoEstado) {
        this.proximoEstado = proximoEstado;
        terminou = true;
    }

    @Override
    public void aoSair() {
        terminou = true;
        renderizar();
    }

    @Override
    public void renderizar() {
        mapa.imprimir(treinador.getX(), treinador.getY());

    }

    @Override
    public boolean terminou() {
        return terminou;
    }

    @Override
    public EstadoEnum getProximoEstado() {
        return proximoEstado;
    }

    public boolean achouPokemon() {
        Random random = new Random();
        int dado1 = random.nextInt(6) + 1;
        return dado1 != 6;
    }
}
