package game.model;

import game.BancoDePokemon;
import game.Pokemon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pokedex implements PokedexEventos{

    private List<Pokemon> meusPokemons;
    private Map<String, Integer> pokemonCapturados;
    private Map<String, Boolean> pokemonsVistos;

    public Pokedex() {
        meusPokemons = new ArrayList<>();
        pokemonCapturados = new HashMap<>();
        pokemonsVistos = new HashMap<>();
    }

    @Override
    public void aoCapturar(Pokemon pokemon) {
        meusPokemons.add(pokemon);
        Integer nExemplaresCapturados = 0;
        if(pokemonCapturados.containsKey(pokemon.getNome())){
            nExemplaresCapturados = pokemonCapturados.get(pokemon.getNome());
        }
        pokemonCapturados.put(pokemon.getNome(), nExemplaresCapturados + 1);
    }

    @Override
    public void aoVerPokemon(Pokemon pokemon) {
        if(!pokemonsVistos.containsKey(pokemon.getNome())) {
            pokemonsVistos.put(pokemon.getNome(), Boolean.TRUE);
        }
    }

    public String getPokemons() {
        StringBuilder builder = new StringBuilder();
        int n = 1;
        int vistos = 0, capturados = 0;
        for (String pokemon : BancoDePokemon.POKEMONS) {
            builder.append(n + " - ");
            if(pokemonCapturados.containsKey(pokemon)) {
                builder.append(pokemon + "*");
                capturados++;
                vistos++;
            } else if (pokemonsVistos.containsKey(pokemon)) {
                builder.append(pokemon);
                vistos++;
            }
            builder.append("\n");
            n++;
        }
        builder.append("Voce encontrou " + vistos + " pokemons de especies diferentes\n e capturou " + capturados + " especies diferentes");
        return  builder.toString();
    }
}
