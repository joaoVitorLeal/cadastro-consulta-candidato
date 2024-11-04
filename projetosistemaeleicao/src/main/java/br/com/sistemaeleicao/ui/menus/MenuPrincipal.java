package br.com.sistemaeleicao.ui.menus;

import br.com.sistemaeleicao.servicos.candidato.ServicosCadastroCandidato;
import br.com.sistemaeleicao.modelo.Candidato;
import br.com.sistemaeleicao.banco.de.dados.dao.CandidatoDAO;
import br.com.sistemaeleicao.banco.de.dados.ConexaoBancoDados;

import java.sql.Connection;
import java.util.Scanner;

/**
 * @author joaoleal
 */

public class MenuPrincipal extends Menu {
   
    @Override
    public void exibirOpcoes() {
        System.out.println("""
                \n\n Menu Principal:
                           
                • Para cadastrar um(a) novo(a) candidato(a) digite [1].

                • Caso já seja cadastrado, entre como candidato, digitando [2].

                • Para entrar como Eleitor e realizar consultas, digite o número [3].

                • Se deseja sair do nosso programa digite o número [4].

               ->\n\n""");
    }


    
    @Override
    public void processarEntradas(Scanner sc) {
        int inputUsuario = 0;
        
        do {
            exibirOpcoes();
             
            try {
                inputUsuario = Integer.parseInt(sc.nextLine());
                
                switch (inputUsuario) {
                    case 1 -> { 
                        Candidato candidato = ServicosCadastroCandidato.cadastrarCandidato(sc);
                        
                        if (candidato != null) {
                            System.out.println("\nAntes de prosseguirmos, confira se os dados do(a) candidato(a) estão corretos:\n\n" + candidato + "\n");
                            System.out.println("Se os dados estiverem corretos digite [s], caso contrário digite [n]: ");
                            
                            String inputVerificacao = sc.nextLine();
                            
                            if (inputVerificacao.equals("s")) {
                                
                                Connection conn = ConexaoBancoDados.conectar();
                                new CandidatoDAO().inserirCandidato(conn, candidato);
                                ConexaoBancoDados.desconectar(conn);   
                                
                            } else {
                                System.err.println("\n@@@  Candidato não cadastrado. Por favor repetir operação de cadastro, informando os dados corretamente.  @@@\n");
                            } 
                        }
                    }
                    
                    case 2 -> { new MenuCandidato().processarEntradas(sc); }
                   
                    case 3 -> { new MenuEleitor().processarEntradas(sc); }
                    
                    case 4 -> { System.out.println("\nEncerrando o programa...\n"); }
                    
                    default -> { System.out.println("\n@@@  Opção inválida. Por favor, escolha uma opção válida do menu. @@@"); }                     
                }
                
                } catch (NumberFormatException nfe) {
                    System.err.println("\n@@@  Erro: Entrada inválida. Digite um número.  @@@\n");
                    
                } catch (Exception e) {
                    System.err.println("\n@@@  Erro ao inicializar o Menu Principal  @@@.\n");
                    break;
                }
        } while (inputUsuario != 4 ); 
    }
}
