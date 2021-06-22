import java.util.Random;

public class Pokebola {

    public boolean capturar(Pokemon pokemon) {
        Random random = new Random();
        int treinadorDado = random.nextInt(6) + 1;
        int pokemonDado = random.nextInt(6) + 1;
        return (treinadorDado > pokemonDado);
    }

    @Override
    public String toString() {
        return "Pokebola";
    }
}
