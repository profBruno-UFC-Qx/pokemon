import java.util.List;
import java.util.Random;

public class Batalha {

    private boolean emBatalha;
    private Pokemon pokemon ;
    private List<Pokebola> inventario;

    public Batalha(List<Pokebola> inventario) {
        this.inventario = inventario;
    }

    public void iniciar() {
        emBatalha = true;
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
                if (inventario.isEmpty()) {
                    System.out.println("Voce nao tem mais pokebolas");
                } else {
                    Pokebola pokebola = inventario.remove(0);
                    System.out.print("Voce usou uma " + pokebola + " e ");
                    if (pokebola.capturar(pokemon)) {
                        System.out.println("capturou um " + getPokemon());
                        emBatalha = false;
                        return true;
                    } else {
                        System.out.println("o " + getPokemon() + " quebrou sua " + pokebola);
                    }
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

    public Pokemon getPokemon() {
        return pokemon;
    }

    public boolean correr() {
        emBatalha = false;
        return true;
    }

}
