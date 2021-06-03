public class Mundo {

    private final int maxX;
    private final int maxY;
    private int x = 0;
    private int y = 0;

    public Mundo(int maxX, int maxY){
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public boolean move(String direcao) {
        switch (direcao) {
            case "pf":
                y++;
                return true;
            case "pt":
                y--;
                return true;
            case "dir":
                x++;
                return true;
            case "esq":
                x--;
                return true;
            default:
                return false;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
