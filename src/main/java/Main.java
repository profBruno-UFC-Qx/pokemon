import java.util.Scanner;


public class Main {

    private static final int MAX_X = 20;
    private static final int MAX_Y = 5;

    private static final int MODO_MAPA = 0;
    private static final int MODO_BATALHA = 1;

    public static void main(String[] args) {

        int modo =  MODO_MAPA;

        Scanner scanner = new Scanner(System.in);
        String opcao = "";
        Mundo mundo = new Mundo(MAX_X, MAX_Y);
        Mapa mapa = new Mapa(MAX_X, MAX_Y);
        Batalha batalha = null;
        boolean skip = false;


        System.out.println("Bem vindo ao jogo Pokemon");
        mapa.imprimir(mundo.getX(), mundo.getY());

        do {
            if (!skip) {
                opcao = scanner.nextLine();
            } else {
                skip = false;
            }

            if ("sair".equalsIgnoreCase(opcao)) {
                System.out.println("Tchau. Ate a proxima.");
                System.exit(0);
            } else {
                switch (modo) {
                    case MODO_MAPA:
                        if (mundo.move(opcao) && Batalha.achouPokemon()) {
                            mapa.imprimir(mundo.getX(), mundo.getY());
                            modo = MODO_BATALHA;
                            skip = true;
                        } else {
                            System.out.println("Opcao invalida");
                        }
                        break;

                    case MODO_BATALHA:
                        if (batalha == null) {
                            batalha = new Batalha();
                            batalha.iniciar();
                        } else {
                            if (batalha.tratarOpcao(opcao)) {
                                if (!batalha.estaEmBatalha()) {
                                    modo = MODO_MAPA;
                                    mapa.imprimir(mundo.getX(), mundo.getY());
                                    batalha = null;
                                }
                            } else {
                                System.out.println("Opcao invalida");
                            }
                        }
                        break;
                }
            }
        } while(!"sair".equalsIgnoreCase(opcao));
    }
}
