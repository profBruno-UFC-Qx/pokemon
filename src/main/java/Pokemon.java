import java.util.Random;

public class Pokemon {

    private String nome;
    private String apelido;
    private int nivel;
    private Sexo sexo = Sexo.FEMININO;

    enum Sexo {
        MASCULINO("M"), FEMININO("F");

        private String abreviacao;

        Sexo(String abreviacao) {
            this.abreviacao = abreviacao;
        }

        @Override
        public String toString() {
            return abreviacao;
        }
    }

    public Pokemon(String nome) {
        this.nome = nome;
        this.nivel = 1;
        Random random = new Random();
        int i = random.nextInt(1);
        if (i == 0) {
            sexo = Sexo.MASCULINO;
        }
    }

    @Override
    public String toString() {
        return nome +"["+ nivel+ "](" + sexo + ")";
    }
}
