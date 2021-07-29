package game.model;

import game.BancoDePokemon;
import game.Pokemon;

import java.util.*;

public class Pokedex implements PokedexEventos {

    private List<Pokemon> meusPokemons;
    private Set<String> vistos;
    private Map<String, Integer> capturados;

    public Pokedex() {
        meusPokemons = new ArrayList<>();
        vistos = new HashSet<>();
        capturados = new HashMap<>();
    }

    public Pokedex(Collection<Pokemon> meusPokemons, Collection<String> vistos) {
        this.meusPokemons = new ArrayList<>();
        this.vistos = new HashSet<>(vistos);
        capturados = new HashMap<>();
        for (Pokemon pokemon: meusPokemons) {
            aoCapturar(pokemon);
        }
    }

    @Override
    public void aoCapturar(Pokemon pokemon) {
        meusPokemons.add(pokemon);
        int qtdCapturados = 0;
        if(capturados.containsKey(pokemon.getNome())) {
            qtdCapturados = capturados.get(pokemon.getNome());
        }
        capturados.put(pokemon.getNome(), qtdCapturados + 1);
    }

    private int getCapturadosPorEspecie(String especie) {
        int resultado = 0;
        if(capturados.containsKey(especie)) {
            resultado = capturados.get(especie);
        }
        return resultado;
    }

    @Override
    public void aoVerPokemon(Pokemon pokemon) {
        vistos.add(pokemon.getNome());
    }

    public List<Pokemon> getMeusPokemons() {
        return meusPokemons;
    }

    public Set<String> getPokemonVistos() {
        return vistos;
    }

    public String getPokemons() {

        StringBuilder resultado = new StringBuilder();

        for(int i = 0; i < BancoDePokemon.POKEMONS.length; i++) {
            String nomePokemon = BancoDePokemon.POKEMONS[i];


            boolean capturado = meusPokemons.stream().anyMatch(p -> p.getNome().equals(nomePokemon));
            boolean visto = vistos.contains(nomePokemon);
            int nCapturados = getCapturadosPorEspecie(nomePokemon);

            resultado.append(i+1).append(" -> ");

            if(visto) {
                resultado.append(nomePokemon);
            } else {
                resultado.append("???");
            }

            if(capturado) {
                resultado.append(" x").append(nCapturados);
            }
            resultado.append("\n");
        }

        resultado.append("Voce encontrou ")
                .append(vistos.size())
                .append(" pokemons de especies diferentes\n e capturou ")
                .append(meusPokemons.size())
                .append(" pokemons");

        return resultado.toString();
    }
}
