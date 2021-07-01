package game.estados;

public interface Estado {
    void aoEntrar();
    void atualizar(String entrada);
    void aoSair();
    void renderizar();
    boolean terminou();
    EstadoEnum getProximoEstado();
}
