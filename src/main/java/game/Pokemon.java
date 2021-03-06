package game;

import java.util.Random;

public class Pokemon {

    private String nome;
    private String apelido;
    private int nivel;
    private Sexo sexo;
    private int pvMax = 100;
    private int pvAtual = 30;
    private int velocidade;
    private int altura;
    private int peso;
    private int nivelDeAmizade;
    private int taxaDeCaptura = 100;

    public enum Sexo {
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

    public Pokemon(String nome, int altura, int peso, int velocidade) {
        this.nome = nome;
        this.nivel = 1;
        this.altura = altura;
        this.peso = peso;
        this.velocidade = velocidade;
        Random random = new Random();
        sexo = Sexo.values()[random.nextInt(Sexo.values().length)];

    }

    public String getNome() {
        return nome;
    }

    public int getPvMax() {
        return pvMax;
    }

    public void setPvAtual(int pvAtual) {
        this.pvAtual = pvAtual;
    }

    public int getPvAtual() {
        return pvAtual;
    }

    public int getAltura() { return altura; }

    public int getVelocidade() {
        return velocidade;
    }

    public int getPeso() {
        return peso;
    }

    public int getTaxaDeCaptura() {
        return taxaDeCaptura;
    }

    public int getNivelDeAmizade() {
        return nivelDeAmizade;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public int getNivel() { return nivel; }

    public void setNivelDeAmizade(int nivelDeAmizade) {
        this.nivelDeAmizade = nivelDeAmizade;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public void setPvMax(int pvMax) {
        this.pvMax = pvMax;
    }

    public void setTaxaDeCaptura(int taxaDeCaptura) {
        this.taxaDeCaptura = taxaDeCaptura;
    }

    public void setNivel(int nivel) { this.nivel = nivel; }

    @Override
    public String toString() {
        return nome +"{" +
                "pv=" + pvAtual +
                ", vel=" + velocidade +
                ", peso=" + peso +
                ", amizade=" + nivelDeAmizade +
                "}["+ nivel +"](" + sexo + ")";
    }
}
