public class Mapa {

    private final int largura;
    private final int altura;

    public Mapa(int largura, int altura) {
        this.largura = largura;
        this.altura = altura;
    }

    public void imprimir(int x, int y) {
        String limitador = new String(new char[largura]).replace("\0", "-");
        String emBranco = new String(new char[largura - 1]).replace("\0", " ") + "|";

        System.out.println(limitador);
        for(int i = 0; i < y ; i++){
            System.out.println(emBranco);
        }
        for(int i = 0; i <= x - 1 ; i++){
            System.out.print(" ");
        }
        System.out.print("o");
        for(int i = x + 1; i < largura - 1 ; i++){
            System.out.print(" ");
        }
        System.out.println("|");
        for(int i = y; i < altura; i++){
            System.out.println(emBranco);
        }
        System.out.println(limitador);
    }
}
