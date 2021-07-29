package game.util;

import game.Pokemon;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CSVParser {

    private enum PokemonFields{
        NOME, ALTURA, PESO, VELOCIDADE, PV_MAX, PV_ATUAL, TAXA, AMIZADE, SEXO, NIVEL;

    }

    public String pokemonToCsv(Pokemon pokemon) {
        String[] campos = {
                pokemon.getNome(),
                String.valueOf(pokemon.getAltura()),
                String.valueOf(pokemon.getPeso()),
                String.valueOf(pokemon.getVelocidade()),
                String.valueOf(pokemon.getPvMax()),
                String.valueOf(pokemon.getPvAtual()),
                String.valueOf(pokemon.getTaxaDeCaptura()),
                String.valueOf(pokemon.getNivelDeAmizade()),
                pokemon.getSexo().name(),
                String.valueOf(pokemon.getNivel())
        };
        return Stream.of(campos).collect(Collectors.joining(","));
    }

    public String getCabecalhoPokemonCSV() {
        return Arrays.stream(PokemonFields.values())
                .map(constante -> constante.name())
                .collect(Collectors.joining(",")
        );
    }

    private int getCampos(String[] campos, PokemonFields campo) {
        return Integer.parseInt(campos[campo.ordinal()]);
    }

    public Pokemon csvToPokemon(String linha) {
        String[] campos = linha.split(",");
        Pokemon pokemon = new Pokemon(campos[PokemonFields.NOME.ordinal()],
                getCampos(campos, PokemonFields.ALTURA),
                getCampos(campos, PokemonFields.PESO),
                getCampos(campos, PokemonFields.VELOCIDADE));

        pokemon.setPvMax(getCampos(campos, PokemonFields.PV_MAX));
        pokemon.setPvAtual(getCampos(campos, PokemonFields.PV_ATUAL));
        pokemon.setTaxaDeCaptura(getCampos(campos, PokemonFields.TAXA));
        pokemon.setNivelDeAmizade(getCampos(campos, PokemonFields.AMIZADE));
        pokemon.setSexo(Pokemon.Sexo.valueOf(campos[PokemonFields.SEXO.ordinal()]));
        pokemon.setNivel(getCampos(campos, PokemonFields.NIVEL));

        return pokemon;
    }

}
