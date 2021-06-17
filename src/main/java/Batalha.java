import java.util.Random;

public class Batalha {

    private boolean emBatalha;
    private Random random;
    private int tentativas;
    private String pokemon ;

    public Batalha() {
        random = new Random();
    }

    public void iniciar() {
        emBatalha = true;
        tentativas = 3;
        pokemon = BancoDePokemon.getRandomPokemon();
        System.out.println("Apareceu um "
                + pokemon
                + " selvagem!");
        mostarOpcoes();
    }

    private void mostarOpcoes() {
        System.out.println("[C]orrer!");
        System.out.println("[P]okebola");
    }

    public boolean tratarOpcao(String opcao) {
        switch (opcao) {
            case "C":
                if(correr()) {
                    System.out.println("Ufa. Vc escapou.");
                    return true;
                }
                break;
            case "P":
                if (capturar()) {
                    System.out.println("Vc capturou um " + getPokemon());
                    return true;
                } else {
                    System.out.println("O " + getPokemon() + " quebrou sua pokebola");
                }
                break;
            default:
                return false;
        }
        mostarOpcoes();
        return true;
    }

    public boolean estaEmBatalha() {
        return emBatalha;
    }

    public static boolean achouPokemon() {
        Random random = new Random();
        int dado1 = random.nextInt(6) + 1;
        return dado1 != 6;
    }

    public String getPokemon() {
        return pokemon;
    }

    public boolean capturar(){
        int treinadorDado = random.nextInt(6) + 1;
        int pokemonDado = random.nextInt(6) + 1;
        tentativas--;
        if (treinadorDado > pokemonDado) {
            emBatalha = false;
            return true;
        } else {
            if (tentativas == 0) {
                System.out.println("O " + pokemon + "escapou");
                emBatalha = false;
                pokemon = null;
            }
            return false;
        }
    }

    public boolean correr() {
        emBatalha = false;
        pokemon = null;
        return true;
    }

}
