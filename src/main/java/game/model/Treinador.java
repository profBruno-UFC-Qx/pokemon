package game.model;

public class Treinador extends Ator {

    private int x;
    private int y;
    private Pokedex pokedex;

    public Treinador() {
        pokedex = new Pokedex();
    }

    public Treinador(Pokedex pokedex) {
        this.pokedex = pokedex;
    }

    public Pokedex getPokedex() {
        return pokedex;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void move(Direcao direcao) {
        switch (direcao) {
            case CIMA:
                y++;
                break;

            case BAIXO:
                y--;
                break;

            case DIREITA:
                x++;
                break;

            case ESQUERDA:
                x--;
        }
    }
}
