package br.com.sistemaeleicao.banco.de.dados.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;
import java.time.LocalDate;

import br.com.sistemaeleicao.modelo.Candidato;


/**
 * Classe responsável por centraliza o acesso ao banco de dados pelos métodos CRUD(Create, Update e Delete).
 * 
 * @author joaoleal
 */

public class CandidatoDAO {
    
        /*  Métodos públicos que chamam os métodos privados para realizar manipulações e deleções  */  
    
    public void inserirCandidato(Connection conn, Candidato candidato) {
        inserir(conn, candidato);
    }  
    
    public void deletarCandidato(Connection conn, Scanner sc) {
        deletar(conn, sc);
    }
    
    public void atualizarCandidato(Connection conn, Scanner sc) {
        atualizar(conn, sc);
    }
    
    public void atualizarLocalidadeCandidato(Connection conn, Scanner sc) {
        atualizarLocalidade(conn, sc);
    }
    
    public void atualizarOrientacaoIdeologicaCandidato(Connection conn, Scanner sc) {
        atualizarOrientacaoIdeologica(conn, sc);
    }
    
    public void atualizarPautasCandidato(Connection conn, Scanner sc) {
        atualizarPautas(conn, sc);
    }
    
    public void atualizarCargoCandidato(Connection conn, Scanner sc) {
        atualizarCargoAlmejado(conn, sc);
    }
    
    
        /* Métodos privados que implementam a lógica das operaçoes */
    
    // Metodo para inserir candidato ao banco de dados
    private void inserir(Connection conn, Candidato candidato){
        if (candidato != null) {
            String sql = "INSERT INTO candidatos (numero_registro, nome, data_nascimento, localidade, orientacao_ideologica, pautas, cargo_almejado) VALUES (?, ?, ?, ?, ?, ?, ?);";
            
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, candidato.getNumeroRegistro());
                stmt.setString(2, candidato.getNome());
                stmt.setDate(3, Date.valueOf(candidato.getDataNascimento()));
                stmt.setString(4, candidato.getLocalidade());
                stmt.setString(5, candidato.getOrientacaoIdeologica());
                stmt.setString(6, candidato.getPautas());
                stmt.setString(7, candidato.getCargoDesejado());
                
                stmt.executeUpdate();
                
                System.out.println("\n☰☰☰  Candidato cadastrado com sucesso!  ☰☰☰\n");
                
            } catch (SQLException sqle) {
                System.err.println("\nErro ao cadastrar candidato. Por favor tente novamente mais tarde.");
                System.err.println("Código de erro: " + sqle.getErrorCode());
                System.err.println("Descrição: " + sqle.getMessage() + "\n");
            }
        }  
    }
    
    // Método para deletar candidato do banco de dados
    private void deletar(Connection conn, Scanner sc) {
        String sql = "DELETE FROM candidatos WHERE id = ?;";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            System.out.println("\nInforme o ID do(a) candidato(a) que deseja deletar: ");
            int id = Integer.parseInt(sc.nextLine());
            
            pstmt.setInt(1, id);
            
            int linhasDeletadas = pstmt.executeUpdate();
            
            if (linhasDeletadas > 0) {
                System.out.println("\n☰☰☰  Deleção realizada com sucesso!  ☰☰☰\n");
            } else {
                System.err.println("\nNão foi encontrado nenhum usuário com o ID fornecido. Por favor realize a operação novamente, informando um ID válido.");
            }
            
        } catch (SQLException sqle) {
                System.err.println("\nERRO: Não foi possível realizar a deleção do usuário do banco de dados.");
                System.err.println("Código de erro: " + sqle.getErrorCode());
                System.err.println("Descrição: " + sqle.getMessage() + "\n");
        }
    }
    
    // Metodo para atualizar todos os dados do candidato
    private void atualizar(Connection conn, Scanner sc) {
        String sql = "UPDATE candidatos SET numero_registro = ?, nome = ?, data_nascimento = ?, localidade = ?, orientacao_ideologica = ?, pautas = ?, cargo_almejado = ?  WHERE id = ?;";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            System.out.println("\nInforme o ID do(a) candidato(a) que deseja atualizar: ");
            int id = Integer.parseInt(sc.nextLine());
            
            System.out.println("Informe o novo número de registro do(a) candidato(a): ");
            int numeroRegistro = Integer.parseInt(sc.nextLine());

            System.out.println("Informe o novo nome do(a) candidato(a): ");
            String nome = sc.nextLine();

            System.out.println("Informe a nova data de nascimento do(a) candidato(a) (formato: AAAA-MM-DD): ");
            String dataNascimentoStr = sc.nextLine();
            LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr);

            System.out.println("Informe a nova localidade do(a) candidato(a): ");
            String localidade = sc.nextLine().toUpperCase();

            System.out.println("Informe a nova orientação ideológica (ESQUERDA, CENTRO, DIREITA) do(a) candidato(a): ");
            String orientacaoIdeologica = sc.nextLine().toUpperCase();

            System.out.println("Informe as novas pautas do(a) candidato(a): ");
            String pautas = sc.nextLine();

            System.out.println("Informe o novo cargo almejado pelo(a) candidato(a): ");
            String cargoAlmejado = sc.nextLine().toUpperCase();
            
            // Configurando os parâmetros na instrução SQL
            pstmt.setInt(1, numeroRegistro);
            pstmt.setString(2, nome);
            pstmt.setDate(3, Date.valueOf(dataNascimento));
            pstmt.setString(4, localidade);
            pstmt.setString(5, orientacaoIdeologica);
            pstmt.setString(6, pautas);
            pstmt.setString(7, cargoAlmejado);
            pstmt.setInt(8, id);
            
            // Executando instuções SQL
            int linhasAtualizadas = pstmt.executeUpdate();
            
            if (linhasAtualizadas > 0) {
                System.out.println("\n☰☰☰  Atualização realizada  ☰☰☰\n");
            } else {
                System.err.println("\nNão foi encontrado nenhum usuário com o ID fornecido. Por favor realize a operação novamente, informando um ID válido.");
            }    
            
        } catch (SQLException sqle) {
            System.out.println("ERRO: Não foi possível atualizar candidato(a) no banco de dados.");
            System.err.println("Código de erro: " + sqle.getErrorCode());
            System.err.println("Descrição: " + sqle.getMessage() + "\n");
        }    
    }
    
    // Método para atualizar a localidade do candidato
    private void atualizarLocalidade(Connection conn, Scanner sc) {
        String sql = "UPDATE candidatos SET localidade = ?  WHERE id = ?;";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            System.out.println("\nInforme o ID do(a) candidato(a) que deseja atualizar: ");
            int id = Integer.parseInt(sc.nextLine());

            System.out.println("Informe a nova localidade do(a) candidato(a): ");
            String localidade = sc.nextLine().toUpperCase();
            
            // Configurando os parâmetros na instrução SQL
            pstmt.setString(1, localidade);
            pstmt.setInt(2, id);
            
            // Executando instuções SQL
            int linhasAtualizadas = pstmt.executeUpdate();
            
            if (linhasAtualizadas > 0) {
                System.out.println("\n☰☰☰  Atualização realizada  ☰☰☰\n");
            } else {
                System.err.println("\nNão foi encontrado nenhum usuário com o ID fornecido. Por favor realize a operação novamente, informando um ID válido.");
            }
            
        } catch (SQLException sqle) {
            System.out.println("ERRO: Não foi possível atualizar 'Localidade' do(a) candidato(a) no banco de dados.");
            System.err.println("Código de erro: " + sqle.getErrorCode());
            System.err.println("Descrição: " + sqle.getMessage() + "\n");
        }    
    } 
    
    // Metodo para atualizar orientacao ideologica do candidato
    private void atualizarOrientacaoIdeologica(Connection conn, Scanner sc) {
        String sql = "UPDATE candidatos SET orientacao_ideologica = ?  WHERE id = ?;";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            System.out.println("\nInforme o ID do(a) candidato(a) que deseja atualizar: ");
            int id = Integer.parseInt(sc.nextLine());

            System.out.println("Informe a nova orientação ideológica (ESQUERDA, CENTRO, DIREITA) do(a) candidato(a): ");
            String orientacaoIdeologica = sc.nextLine().toUpperCase();
            
            // Configurando os parâmetros na instrução SQL
            pstmt.setString(1, orientacaoIdeologica);
            pstmt.setInt(2, id);
            
            // Executando instuções SQL
            int linhasAtualizadas = pstmt.executeUpdate();
            
            if (linhasAtualizadas > 0) {
                System.out.println("\n☰☰☰  Atualização realizada  ☰☰☰\n");
            } else {
                System.err.println("\nNão foi encontrado nenhum usuário com o ID fornecido. Por favor realize a operação novamente, informando um ID válido.");
            }
            
        } catch (SQLException sqle) {
            System.out.println("ERRO: Não foi possível atualizar 'Orientação Ideológica' do(a) candidato(a) no banco de dados.");
            System.err.println("Código de erro: " + sqle.getErrorCode());
            System.err.println("Descrição: " + sqle.getMessage() + "\n");
        }    
    }
    
    
    private void atualizarPautas(Connection conn, Scanner sc) {
        String sql = "UPDATE candidatos SET pautas = ?  WHERE id = ?;";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            System.out.println("\nInforme o ID do(a) candidato(a) que deseja atualizar: ");
            int id = Integer.parseInt(sc.nextLine());

            System.out.println("Informe as novas pautas do(a) candidato(a): ");
            String pautas = sc.nextLine();
            
            // Configurando os parâmetros na instrução SQL
            pstmt.setString(1, pautas);
            pstmt.setInt(2, id);
            
            // Executando instuções SQL
            int linhasAtualizadas = pstmt.executeUpdate();
            
            if (linhasAtualizadas > 0) {
                System.out.println("\n☰☰☰  Atualização realizada  ☰☰☰\n");
            } else {
                System.err.println("\nNão foi encontrado nenhum usuário com o ID fornecido. Por favor realize a operação novamente, informando um ID válido.");
            }
            
        } catch (SQLException sqle) {
            System.out.println("ERRO: Não foi possível atualizar 'Pautas' do(a) candidato(a) no banco de dados.");
            System.err.println("Código de erro: " + sqle.getErrorCode());
            System.err.println("Descrição: " + sqle.getMessage() + "\n");
        }    
    }
    
    
    private void atualizarCargoAlmejado(Connection conn, Scanner sc) {
        String sql = "UPDATE candidatos SET cargo_almejado = ?  WHERE id = ?;";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            System.out.println("\nInforme o ID do(a) candidato(a) que deseja atualizar: ");
            int id = Integer.parseInt(sc.nextLine());

            System.out.println("Informe o novo cargo almejado pelo(a) candidato(a): ");
            String cargoAlmejado = sc.nextLine().toUpperCase();
            
            // Configurando os parâmetros na instrução SQL
            pstmt.setString(1, cargoAlmejado);
            pstmt.setInt(2, id);
            
            // Executando instuções SQL
            int linhasAtualizadas = pstmt.executeUpdate();
            
            if (linhasAtualizadas > 0) {
                System.out.println("\n☰☰☰  Atualização realizada  ☰☰☰\n");
            } else {
                System.err.println("\nNão foi encontrado nenhum usuário com o ID fornecido. Por favor realize a operação novamente, informando um ID válido.");
            }
            
        } catch (SQLException sqle) {
            System.out.println("ERRO: Não foi possível atualizar 'Cargo Almejado' do(a) candidato(a) no banco de dados.");
            System.err.println("Código de erro: " + sqle.getErrorCode());
            System.err.println("Descrição: " + sqle.getMessage() + "\n");
        }    
    } 
}
