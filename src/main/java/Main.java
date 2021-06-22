import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    private static final int MAX_X = 20;
    private static final int MAX_Y = 5;

    enum Modo {
        MODO_MAPA, MODO_BATALHA;
    }

    public static void main(String[] args) {

        Modo modo =  Modo.MODO_MAPA;

        Scanner scanner = new Scanner(System.in);
        String opcao = "";
        Mundo mundo = new Mundo(MAX_X, MAX_Y);
        Mapa mapa = new Mapa(MAX_X, MAX_Y);
        Batalha batalha = null;
        boolean skip = false;

        List<Pokebola> pokebolas = Main.criarInventario();


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
                            modo = Modo.MODO_BATALHA;
                            skip = true;
                        } else {
                            System.out.println("Opcao invalida");
                        }
                        break;

                    case MODO_BATALHA:
                        if (batalha == null) {
                            batalha = new Batalha(pokebolas);
                            batalha.iniciar();
                        } else {
                            if (batalha.tratarOpcao(opcao)) {
                                if (!batalha.estaEmBatalha()) {
                                    modo = Modo.MODO_MAPA;
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

    private static List<Pokebola> criarInventario() {
        List<Pokebola> pokebolas = new ArrayList<Pokebola>();
        pokebolas.add(new Pokebola());
        pokebolas.add(new Pokebola());
        pokebolas.add(new Pokebola());
        pokebolas.add(new GreatPokebola());
        pokebolas.add(new GreatPokebola());
        pokebolas.add(new GreatPokebola());
        pokebolas.add(new UltraPokebola());
        pokebolas.add(new UltraPokebola());
        pokebolas.add(new UltraPokebola());
        pokebolas.add(new MasterPokebola());
        return pokebolas;
    }
}
