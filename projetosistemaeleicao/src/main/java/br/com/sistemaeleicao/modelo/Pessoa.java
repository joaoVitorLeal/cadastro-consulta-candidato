package br.com.sistemaeleicao.modelo;

import java.time.LocalDate;
import java.time.Period;

/**
 * Superclasse usada como molde da subclasse Candidato
 * 
 * @author joaoleal
 */

public abstract class Pessoa {
    private String nome;
    private LocalDate dataNascimento;
    private String localidade;
    
    public Pessoa(){} // Construtor vazio

    public Pessoa(String nome, LocalDate dataNascimento, String localidade) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.localidade = localidade;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    public int getIdade(){
        return calcularIdade();
    }
    
    public String getLocalidade() {
        return this.localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    } 
    
    private int calcularIdade(){
        LocalDate hoje = LocalDate.now();
        return Period.between(this.dataNascimento, hoje).getYears(); // Calcula a diferença entre a data de nascimento e a data atual em anos
    }
}
