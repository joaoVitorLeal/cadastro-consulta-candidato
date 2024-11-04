package br.com.sistemaeleicao.banco.de.dados.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import br.com.sistemaeleicao.banco.de.dados.ConexaoBancoDados;


/**
 * Classe responsável por centralizar o acesso ao banco de dados pelos métodos CRUD(Read).
 * 
 * @author joaoleal
 */

public class CandidatoConsultaDAO {
    
    public void exibirTabela() {
        exibir();
    }
    
    public void filtroLocalidade(Scanner sc){
        filtrarPorLocalidade(sc);
    }
    
    public void filtroIdeologia(Scanner sc) {
        filtrarPorIdeologia(sc);
    }
    
    public void filtroLocalidadeIdeologia(Scanner sc) {
        filtrarPorLocalidadeIdeologia(sc);
    }
    
    
    private void exibir() {
        String sql = "SELECT * FROM candidatos;";
        
        try (Connection conn = ConexaoBancoDados.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            while(rs.next()) {
                int id = rs.getInt("id");
                int numeroRegistro = rs.getInt("numero_registro");
                String nome = rs.getString("nome");
                LocalDate dataNascimento = rs.getDate("data_nascimento").toLocalDate();
                String localidade = rs.getString("localidade");
                String orientacaoIdeologica = rs.getString("orientacao_ideologica");
                String pautas = rs.getString("pautas");
                String cargoDesejado = rs.getString("cargo_almejado");
                
                /* Formatando data para exibiçao */
                DateTimeFormatter formatoBrasil = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String dataNascimentoFormatada = dataNascimento.format(formatoBrasil);
                
                System.out.println("\n | ID: " + id + " | Número de Registro: " + numeroRegistro + " | Nome: " + nome + " | Data de Nascimento: " + dataNascimentoFormatada + 
                        " | Localidade: " + localidade + " | Orientação Ideológica: " + orientacaoIdeologica + " | Cargo Almejado: " + cargoDesejado + " | Pautas: " + pautas + " | ");   
            }
            
        } catch (SQLException sqle) {
            mensagemErroConsulta(sqle);
        }
    }
    
    
    private void filtrarPorLocalidade(Scanner sc) {
        String sql = "SELECT * FROM candidatos WHERE localidade = ?;";
        
        System.out.println("\nInforme a localidade desejada: ");
        String localidade = sc.nextLine().toUpperCase();
        
        try (Connection conn = ConexaoBancoDados.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {
  
            pstmt.setString(1, localidade);
    
            
            try (ResultSet rs = pstmt.executeQuery()) {
                
                while(rs.next()) {
                    int numeroRegistro = rs.getInt("numero_registro");
                    String nome = rs.getString("nome");
                    LocalDate dataNascimento = rs.getDate("data_nascimento").toLocalDate();
                    localidade = rs.getString("localidade");
                    String orientacaoIdeologica = rs.getString("orientacao_ideologica");
                    String pautas = rs.getString("pautas");
                    String cargoDesejado = rs.getString("cargo_almejado");

                    /* Formatando data para exibiçao */
                    DateTimeFormatter formatoBrasil = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    String dataNascimentoFormatada = dataNascimento.format(formatoBrasil);

                    System.out.println("\n | Número de Registro: " + numeroRegistro + " | Nome: " + nome + " | Data de Nascimento: " + dataNascimentoFormatada + 
                            " | Localidade: " + localidade + " | Orientação Ideológica: " + orientacaoIdeologica + " | Cargo Almejado: " + cargoDesejado + " | Pautas: " + pautas + " | ");   
                }     
            }
        } catch (SQLException sqle) {
            mensagemErroConsulta(sqle);
        }
    }
    
    
    private void filtrarPorIdeologia(Scanner sc) {
        String sql = "SELECT * FROM candidatos WHERE orientacao_ideologica = ?;";
        
        System.out.println("\nInforme a ideologia desejada: ");
        String orientacaoIdeologica = sc.nextLine().toUpperCase();
        
        try (Connection conn = ConexaoBancoDados.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql);
            ) {
            
            pstmt.setString(1, orientacaoIdeologica);
            
            try (ResultSet rs = pstmt.executeQuery()) {
            
                while(rs.next()) {
                    int numeroRegistro = rs.getInt("numero_registro");
                    String nome = rs.getString("nome");
                    LocalDate dataNascimento = rs.getDate("data_nascimento").toLocalDate();
                    String localidade = rs.getString("localidade");
                    orientacaoIdeologica = rs.getString("orientacao_ideologica");
                    String pautas = rs.getString("pautas");
                    String cargoDesejado = rs.getString("cargo_almejado");

                    /* Formatando data para exibiçao */
                    DateTimeFormatter formatoBrasil = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    String dataNascimentoFormatada = dataNascimento.format(formatoBrasil);

                    System.out.println("\n | Número de Registro: " + numeroRegistro + " | Nome: " + nome + " | Data de Nascimento: " + dataNascimentoFormatada + 
                            " | Localidade: " + localidade + " | Orientação Ideológica: " + orientacaoIdeologica + " | Cargo Almejado: " + cargoDesejado + " | Pautas: " + pautas + " | ");   
                }
            }
        } catch (SQLException sqle) {
            mensagemErroConsulta(sqle);
        }
    }    
    
    
    private void filtrarPorLocalidadeIdeologia(Scanner sc) {
        String sql = "SELECT * FROM candidatos WHERE localidade = ? AND orientacao_ideologica = ?;";
        
        System.out.println("\nInforme a localidade desejada: ");
        String localidade = sc.nextLine().toUpperCase();
        
        System.out.println("\nInforme a ideologia desejada: ");
        String orientacaoIdeologica = sc.nextLine().toUpperCase();        
        
        try (Connection conn = ConexaoBancoDados.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ) {
            
            pstmt.setString(1, localidade);
            pstmt.setString(2, orientacaoIdeologica);
            
            try(ResultSet rs = pstmt.executeQuery()) {
                
                while(rs.next()) {
                    int numeroRegistro = rs.getInt("numero_registro");
                    String nome = rs.getString("nome");
                    LocalDate dataNascimento = rs.getDate("data_nascimento").toLocalDate();
                    localidade = rs.getString("localidade");
                    orientacaoIdeologica = rs.getString("orientacao_ideologica");
                    String pautas = rs.getString("pautas");
                    String cargoDesejado = rs.getString("cargo_almejado");

                    /* Formatando data para exibiçao */
                    DateTimeFormatter formatoBrasil = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    String dataNascimentoFormatada = dataNascimento.format(formatoBrasil);

                    System.out.println("\n | Número de Registro: " + numeroRegistro + " | Nome: " + nome + " | Data de Nascimento: " + dataNascimentoFormatada + 
                            " | Localidade: " + localidade + " | Orientação Ideológica: " + orientacaoIdeologica + " | Cargo Almejado: " + cargoDesejado + " | Pautas: " + pautas + " | ");   
                } 
            }
        } catch (SQLException sqle) {
            mensagemErroConsulta(sqle);
        }
    }

     
    private String mensagemErroConsulta(SQLException sqle){  
        return "Erro ao consultar tabela." +
               "Código de erro: " + sqle.getErrorCode() +
               "Descrição: " + sqle.getMessage() + "\n";
    }
}
