package game;

import game.estados.*;
import game.model.Treinador;
import game.pokebola.*;

import java.util.*;


public class Main {

    public static void main(String[] args) {

        Deque<String> mensageria = new ArrayDeque<>();
        System.out.println("Bem vindo ao jogo do pokemon");

        List<Pokebola> pokebolas = Main.criarInventario();
        Treinador treinador = new Treinador();

        MaquinaDeEstados modo = new MaquinaDeEstados();
        modo.adicionar(EstadoEnum.MAPA, new MapaEstado(treinador, mensageria));
        modo.adicionar(EstadoEnum.BATALHA, new BatalhaEstado(pokebolas, treinador.getPokedex(), mensageria));
        modo.adicionar(EstadoEnum.MENU_PRINCIPAL, new MenuPrincipalEstado(treinador.getPokedex(), mensageria));

        Scanner scanner = new Scanner(System.in);
        String opcao = "";

        modo.proximoEstado();

        do {

            if(!mensageria.isEmpty()){
                System.out.println(mensageria.poll());
            }

            if(modo.terminou()){
                modo.proximoEstado();
            } else {
                opcao = scanner.nextLine();

                if (!"sair".equalsIgnoreCase(opcao)) {
                    modo.atualizar(opcao);
                    modo.renderizar();
                }
            }
        } while(!"sair".equalsIgnoreCase(opcao));
        System.out.println("Tchau. Ate a proxima.");
    }

    private static List<Pokebola> criarInventario() {
        List<Pokebola> pokebolas = new ArrayList<Pokebola>();
        pokebolas.add(new Pokebola());
        pokebolas.add(new FriendPokebola());
        pokebolas.add(new FriendPokebola());
        pokebolas.add(new FastPokebola());
        pokebolas.add(new FastPokebola());
        pokebolas.add(new HeavyPokebola());
        pokebolas.add(new HeavyPokebola());
        pokebolas.add(new HealPokebola());
        pokebolas.add(new GreatPokebola());
        pokebolas.add(new UltraPokebola());
        pokebolas.add(new MasterPokebola());
        return pokebolas;
    }
}
