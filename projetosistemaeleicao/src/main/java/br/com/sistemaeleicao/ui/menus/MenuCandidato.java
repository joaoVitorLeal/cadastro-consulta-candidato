package br.com.sistemaeleicao.ui.menus;

import java.sql.Connection;
import java.util.Scanner;

import br.com.sistemaeleicao.banco.de.dados.dao.CandidatoDAO;
import br.com.sistemaeleicao.banco.de.dados.ConexaoBancoDados;


/**
 * @author joaoleal
 */

public class MenuCandidato extends Menu {
    
    @Override
    public void exibirOpcoes() {
        System.out.println( """
                \n         
                • Para atualizar todos os dados de um(a) candidato(a), digite o número [1].
                            
                - Para atualizações especificas:              
                    • Atualizar 'localidade' de um(a) candidato(a), digite o número [2].
                            
                    • Atualizar 'orientação ideológica' de um(a) candidato(a), digite o número [3].  
                                                       
                    • Atualizar 'pautas' de um(a) candidato(a), digite o número [4].       
                                                                                       
                    • Atualizar 'cargo almejado' de um(a) candidato(a), digite o número [5].
                            
                            
                • Deletar cadastro de um(a) candidato(a), digite o número [6].
               
                • Se deseja retornar ao menu principal, digite o número [7].

               ->\n\n""");
    }
    
    
    @Override
    public void processarEntradas(Scanner sc) {
        System.out.println("\nOlá, Seja muito bem-vindo(a) candidato(a)!\n".toUpperCase());
        int inputCandidato = 1;
       

       do {
            exibirOpcoes();
           
           try {
               inputCandidato = Integer.parseInt(sc.nextLine());
               
               switch (inputCandidato) {
                   case 1 -> { 
                        Connection conn = ConexaoBancoDados.conectar();
                        new CandidatoDAO().atualizarCandidato(conn, sc);
                        ConexaoBancoDados.desconectar(conn);
                   }
                   
                   case 2 -> {
                        Connection conn = ConexaoBancoDados.conectar();
                        new CandidatoDAO().atualizarLocalidadeCandidato(conn, sc);
                        ConexaoBancoDados.desconectar(conn);
                   }
                   
                   case 3 -> {
                        Connection conn = ConexaoBancoDados.conectar();
                        new CandidatoDAO().atualizarOrientacaoIdeologicaCandidato(conn, sc);
                        ConexaoBancoDados.desconectar(conn);
                   }
                   
                   case 4 -> {
                        Connection conn = ConexaoBancoDados.conectar();
                        new CandidatoDAO().atualizarPautasCandidato(conn, sc);
                        ConexaoBancoDados.desconectar(conn);
                   }
                   
                   case 5 -> {
                        Connection conn = ConexaoBancoDados.conectar();
                        new CandidatoDAO().atualizarCargoCandidato(conn, sc);
                        ConexaoBancoDados.desconectar(conn);
                   }
                   
                   case 6 -> { 
                        Connection conn = ConexaoBancoDados.conectar();
                        new CandidatoDAO().deletarCandidato(conn, sc);
                        ConexaoBancoDados.desconectar(conn);
                   }
                   
                   case 7 -> { System.out.println("\nRetornando ao menu principal...\n"); }
                   
                   default -> { System.out.println("\n@@@  Opção inválida. Por favor, escolha uma opção válida do Menu Candidato.  @@@"); }
               }
               
               
            } catch (NumberFormatException nfe) {
                    System.err.println("\nErro: Entrada inválida. Digite um número.\n");  
                    
            } catch (Exception e) {
                    System.err.println("\nErro ao inicializar o Menu Candidato.\n");
                    break;
            }
           
       } while (inputCandidato != 7);
    }
}
