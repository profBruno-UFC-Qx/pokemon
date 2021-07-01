package game.model;

public interface Posicionavel {

    enum Direcao {
        DIREITA, ESQUERDA, CIMA, BAIXO;

    }

    int getX();
    int getY();
    void move(Direcao direcao);
}
