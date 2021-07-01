package game.estados;

import java.util.*;

public class MaquinaDeEstados {

    private Map<EstadoEnum, Estado> estados = new HashMap<>();
    private Deque<Estado> pilhaDeEstados = new ArrayDeque<>();

    public MaquinaDeEstados() {
        pilhaDeEstados.push(new InicialEstado());
    }

    public void atualizar(String entrada) {
        pilhaDeEstados.getLast().atualizar(entrada);
    }

    public void renderizar() {
        pilhaDeEstados.getLast().renderizar();

    }

    public boolean terminou() {
        return pilhaDeEstados.getLast().terminou();
    }

    public void adicionar(EstadoEnum estadoEnum, Estado estado) {
        estados.put(estadoEnum, estado);
    }

    public void proximoEstado() {
        Estado atual = pilhaDeEstados.poll();
        if(atual != null) { atual.aoSair(); }

        Estado proximo = estados.get(atual.getProximoEstado());
        proximo.aoEntrar();

        if(pilhaDeEstados.isEmpty() || !pilhaDeEstados.getLast().equals(proximo)){
            pilhaDeEstados.push(proximo);
        }

    }
}
