package br.com.sistemaeleicao.modelo;


import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;

/**
 * Classe que representa um Candidato no sistema, sendo herdeira da classe Pessoa.
 * 
 * @author joaoleal
 */
         
public class Candidato extends Pessoa {
    private Integer numeroRegistro;
    private String orientacaoIdeologica;
    private String pautas;
    private String cargoDesejado;
    
    public Candidato(){}
    
    public Candidato(Integer numeroRegistro, String nome, LocalDate dataNascimento, String localidade, String orientacaoIdeologica, String pautas, String cargoDesejado) {
        super(nome, dataNascimento, localidade);
        this.numeroRegistro = numeroRegistro;
        this.orientacaoIdeologica = orientacaoIdeologica;
        this.pautas = pautas;
        this.cargoDesejado = cargoDesejado;
    }
    
    public Integer getNumeroRegistro() {
        return this.numeroRegistro;
    }

    public void setNumeroRegistro(Integer numeroRegistro) {
        if (!(this.numeroRegistro != null)){
            this.numeroRegistro = numeroRegistro;
        } else {
            System.err.println("Erro: ID do candidato já atribuído.\n");
        }
    }

    public String getOrientacaoIdeologica() {
        return this.orientacaoIdeologica;
    }

    public void setOrientacaoIdeologica(String orientacaoIdeologica) {
        this.orientacaoIdeologica = orientacaoIdeologica;
    }
    
    public String getPautas() {
        return this.pautas;
    }
    
    public void setPautas(String pautas) {
        this.pautas = pautas;
    }
    
    public String getCargoDesejado() {
        return this.cargoDesejado;
    }
    
    public void setCargoDesejado(String cargoDesejado) {
        this.cargoDesejado = cargoDesejado;
    }
        

    @Override
    public String toString() {
        return """
               Candidato {
                  Número de Registro: """ + getNumeroRegistro() + "\n" +
                "   Nome: " + getNome() + "\n" +
                "   Idade: " + getIdade() + "\n" +
                "   Localidade: " + getLocalidade() + "\n" +
                "   Orientação Ideológica: " + getOrientacaoIdeologica() + "\n" +
                "   Cargo Desejado: " + getCargoDesejado() + "\n" +
                '}';
    }
}
