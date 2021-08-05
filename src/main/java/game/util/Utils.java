package game.util;

import game.Pokemon;
import game.model.Pokedex;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

public class Utils {

    private static final String PLAYER_POKEMONS_CSV = "meus_pokemons.csv";
    private static final String PLAYER_POKEMONS_VISTOS_CSV = "pokemons_vistos.csv";
    private static final String CABECALHO_VISTOS = "NOME";

    public static Pokedex carregarPokedex() {
        List<Pokemon> pokemons = new ArrayList<>();
        CSVParser parser = new CSVParser();
        carregarCSV(PLAYER_POKEMONS_CSV, pokemons, parser::csvToPokemon);

        Set<String> vistos = new HashSet<>();
        carregarCSV(PLAYER_POKEMONS_VISTOS_CSV, vistos, (pokemonName -> pokemonName));

        Pokedex pokedex = new Pokedex(pokemons, vistos);
        return pokedex;
    }

    private static <T> void carregarCSV(String nomeDoArquivo, Collection<T> collection, Function<String, T> parserFunction) {
        try (BufferedReader br = new BufferedReader(new FileReader(nomeDoArquivo))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                collection.add(parserFunction.apply(line));
            }
        } catch (FileNotFoundException e) {
            System.out.println("O novo arquivo sera criado");
        } catch (IOException e) {
            System.out.println("Algo muito errado aconteceu. O arquivo de configuracao nao foi criado");
            System.exit(0);
        }
    }


    public static void salvarPokedex(Pokedex pokedex) {

        CSVParser parser = new CSVParser();

        salvarNoArquivo(PLAYER_POKEMONS_CSV,
                parser.getCabecalhoPokemonCSV(),
                pokedex.getMeusPokemons().stream().map(parser::pokemonToCsv));

        salvarNoArquivo(PLAYER_POKEMONS_VISTOS_CSV,
                CABECALHO_VISTOS,
                pokedex.getPokemonVistos().stream());
    }

    private static void salvarNoArquivo(String nomeDoArquivo, String cabecalho, Stream<String> content) {
        File csvOutputFile = new File(nomeDoArquivo);
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            pw.println(cabecalho);
            content.forEach(pw::println);
        } catch (FileNotFoundException e) {
            System.out.println("Nao foi possivel salvar os arquivos de configuracao");
        }
    }
}


