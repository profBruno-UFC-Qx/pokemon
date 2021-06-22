import java.util.Random;

public class GreatPokebola extends Pokebola {

    @Override
    public boolean capturar(Pokemon pokemon) {
        Random random = new Random();
        int treinadorDado = random.nextInt(5) + 2;
        int pokemonDado = random.nextInt(6) + 1;
        return (treinadorDado > pokemonDado);
    }

    @Override
    public String toString() {
        return "GreatPokebola";
    }
}