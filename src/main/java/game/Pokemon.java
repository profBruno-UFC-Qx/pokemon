package game;

import java.util.Random;

public class Pokemon {

    private String nome;
    private String apelido;
    private int nivel;
    private Sexo sexo = Sexo.FEMININO;
    private int velocidade;
    private float peso;
    private float altura;
    private int hpAtual = 70;
    private int hpMax = 100;
    private int taxaDeCaptura = 100;

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

    public Pokemon(String nome, int velocidade, float peso, float altura) {
        this.nome = nome;
        this.nivel = 1;
        this.velocidade = velocidade;
        this.peso = peso;
        this.altura = altura;
        Random random = new Random();
        sexo = Sexo.values()[random.nextInt(2)] ;
    }

    public String getNome() {
        return nome;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public float getPeso() {
        return peso;
    }

    public float getAltura() {
        return altura;
    }

    public int getHpAtual() {
        return hpAtual;
    }

    public int getHpMax() {
        return hpMax;
    }

    public int getTaxaDeCaptura() {
        return taxaDeCaptura;
    }

    @Override
    public String toString() {
        return nome +" [nivel=" + nivel +
                ", velocidade=" + velocidade +
                ", peso=" + String.format("%.2f",peso) +
                ", altura=" + String.format("%.2f",altura) +
                ']' + "(" + sexo + ")";
    }
}
