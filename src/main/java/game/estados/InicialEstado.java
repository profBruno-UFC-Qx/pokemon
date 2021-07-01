package game.estados;

public class InicialEstado implements Estado{
    @Override
    public void aoEntrar() {

    }

    @Override
    public void atualizar(String entrada) {
    }

    @Override
    public void aoSair() {

    }

    @Override
    public void renderizar() {

    }

    @Override
    public boolean terminou() {
        return true;
    }

    @Override
    public EstadoEnum getProximoEstado() {
        return EstadoEnum.MAPA;
    }
}
