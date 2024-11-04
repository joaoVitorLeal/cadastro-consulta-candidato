package br.com.sistemaeleicao.ui.menus;

import java.util.Scanner;

import br.com.sistemaeleicao.banco.de.dados.dao.CandidatoConsultaDAO;


/**
 * 
 * @author joaoleal
 */

public class MenuEleitor extends Menu {
    
    @Override
    public void exibirOpcoes() {
        System.out.println( """
                \n        
                Escolha uma das opções de consulta:

                • Consultar tabela completa de candidatos, digite o número [1].

                - Filtros de consulta:
                   • Consultar por localidade, digite o número [2].
                            
                   • Consultar por orientação ideológica, digite o número [3].
                            
                   • Consultar por localidade e orientação ideológica, digite o número [4].

                            
                • Para retornar ao menu principal, digite o número [5].

               ->\n\n""");
        }
    
    
    @Override
    public void processarEntradas(Scanner sc) {
        System.out.println("\nOlá, Seja muito bem-vindo(a) eleitor(a)!\n".toUpperCase());
       int inputEleitor = 1;

       do {
           exibirOpcoes();
           
           try {
               inputEleitor = Integer.parseInt(sc.nextLine());
               
               switch (inputEleitor) {
                   case 1 -> { new CandidatoConsultaDAO().exibirTabela(); }
                   
                   case 2 -> { new CandidatoConsultaDAO().filtroLocalidade(sc);}
                   
                   case 3 -> { new CandidatoConsultaDAO().filtroIdeologia(sc); }
                   
                   case 4 -> { new CandidatoConsultaDAO().filtroLocalidadeIdeologia(sc); }
                   
                   case 5 -> { System.out.println("\nRetornando ao menu principal..\n"); }
                   
                   default -> { System.out.println("\n@@@  Opção inválida. Por favor, escolha uma opção válida do Menu Candidato.  @@@"); }
               }
               
               
            } catch (NumberFormatException nfe) {
                    // Captura exceções relacionadas a formato inválido ao tentar converter a entrada em um número inteiro
                    System.err.println("\n@@@  Erro: Entrada inválida. Digite um número.  @@@\n");  
                    
            } catch (Exception e) {
                    // Captura outras exceções que possam ocorrer e exibe uma mensagem de erro
                    System.err.println("\n@@@  Erro ao inicializar o Menu Eleitor.  @@@\n");
                    System.err.println(e);
                    break; // Sai do loop se ocorrer uma exceção crítica
            }
           
       } while (inputEleitor != 5);
    }    
}
