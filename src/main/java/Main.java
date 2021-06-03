import java.util.Random;
import java.util.Scanner;


public class Main {

    private static final int MAX_X = 20;
    private static final int MAX_Y = 5;

    private static final String[] POKEMONS = {"Bulbasaur",
            "Ivysaur",
            "Venusaur",
            "Charmander",
            "Charmeleon",
            "Charizard",
            "Squirtle",
            "Wartortle",
            "Blastoise",
            "Caterpie",
            "Metapod",
            "Butterfree",
            "Weedle",
            "Kakuna",
            "Beedrill",
            "Pidgey",
            "Pidgeotto",
            "Pidgeot",
            "Rattata",
            "Raticate",
            "Spearow",
            "Fearow",
            "Ekans",
            "Arbok",
            "Pikachu",
            "Raichu",
            "Sandshrew",
            "Sandslash",
            "Nidoran♀",
            "Nidorina",
            "Nidoqueen",
            "Nidoran♂",
            "Nidorino",
            "Nidoking",
            "Clefairy",
            "Clefable",
            "Vulpix",
            "Ninetales",
            "Jigglypuff",
            "Wigglytuff",
            "Zubat",
            "Golbat",
            "Oddish",
            "Gloom",
            "Vileplume",
            "Paras",
            "Parasect",
            "Venonat",
            "Venomoth",
            "Diglett",
            "Dugtrio",
            "Meowth",
            "Persian",
            "Psyduck",
            "Golduck",
            "Mankey",
            "Primeape",
            "Growlithe",
            "Arcanine",
            "Poliwag",
            "Poliwhirl",
            "Poliwrath",
            "Abra",
            "Kadabra",
            "Alakazam",
            "Machop",
            "Machoke",
            "Machamp",
            "Bellsprout",
            "Weepinbell",
            "Victreebel",
            "Tentacool",
            "Tentacruel",
            "Geodude",
            "Graveler",
            "Golem",
            "Ponyta",
            "Rapidash",
            "Slowpoke",
            "Slowbro",
            "Magnemite",
            "Magneton",
            "Farfetch’d",
            "Doduo",
            "Dodrio",
            "Seel",
            "Dewgong",
            "Grimer",
            "Muk",
            "Shellder",
            "Cloyster",
            "Gastly",
            "Haunter",
            "Gengar",
            "Onix",
            "Drowzee",
            "Hypno",
            "Krabby",
            "Kingler",
            "Voltorb",
            "Electrode",
            "Exeggcute",
            "Exeggutor",
            "Cubone",
            "Marowak",
            "Hitmonlee",
            "Hitmonchan",
            "Lickitung",
            "Koffing",
            "Weezing",
            "Rhyhorn",
            "Rhydon",
            "Chansey",
            "Tangela",
            "Kangaskhan",
            "Horsea",
            "Seadra",
            "Goldeen",
            "Seaking",
            "Staryu",
            "Starmie",
            "Mr. Mime",
            "Scyther",
            "Jynx",
            "Electabuzz",
            "Magmar",
            "Pinsir",
            "Tauros",
            "Magikarp",
            "Gyarados",
            "Lapras",
            "Ditto",
            "Eevee",
            "Vaporeon",
            "Jolteon",
            "Flareon",
            "Porygon",
            "Omanyte",
            "Omastar",
            "Kabuto",
            "Kabutops",
            "Aerodactyl",
            "Snorlax",
            "Articuno",
            "Zapdos",
            "Moltres",
            "Dratini",
            "Dragonair",
            "Dragonite",
            "Mewtwo",
            "Mew"};


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String opcao = "";
        String limitador = new String(new char[MAX_X]).replace("\0", "-");
        String emBranco = new String(new char[MAX_X - 1]).replace("\0", " ") + "|";
        Mundo mundo = new Mundo(MAX_X, MAX_Y);

        System.out.println("Bem vindo ao jogo Pokemon");


        do {
            opcao = scanner.nextLine();
            switch (opcao) {
                case "sair":
                    System.out.println("Tchau. Ate a proxima.");
                    System.exit(0);
                default:
                    if(!mundo.move(opcao)) {
                        System.out.println("Opcao invalida");
                    }
            }

            Random random = new Random();
            int dado1 = random.nextInt(6) + 1;
            if(dado1 != 6) {
               System.out.println("Batalha!");
               String pokemon = POKEMONS[random.nextInt(151)];
               System.out.println("Apareceu um "
                        + pokemon
                        + " selvagem!");
               boolean acabou = false;
               int tentativas = 0;
               do {
                   System.out.println("[C]orrer!");
                   System.out.println("[P]okebola");
                   opcao = scanner.nextLine();
                   switch (opcao) {
                       case "C":
                           System.out.println("Ufa. Vc escapou.");
                           acabou = true;
                           break;
                       case "P":
                           tentativas++;
                           dado1 = random.nextInt(6) + 1;
                           int dado2 = random.nextInt(6) + 1;
                           if (dado1 > dado2) {
                               System.out.println("Vc capturou um " + pokemon);
                               acabou = true;
                           } else {
                               System.out.println("O " + pokemon + " quebrou sua pokebola");
                           }
                           break;
                   }

                   int x = mundo.getX(), y = mundo.getY();
                   System.out.println(limitador);
                   for(int i = 0; i < y ; i++){
                       System.out.println(emBranco);
                   }
                   for(int i = 0; i <= x - 1 ; i++){
                       System.out.print(" ");
                   }
                   System.out.print("o");
                   for(int i = x + 1; i < MAX_X - 1 ; i++){
                       System.out.print(" ");
                   }
                   System.out.println("|");
                   for(int i = y; i < MAX_Y; i++){
                       System.out.println(emBranco);
                   }
                   System.out.println(limitador);

               } while(!acabou && tentativas < 3);
            }


        } while(!"sair".equalsIgnoreCase(opcao));
    }
}
