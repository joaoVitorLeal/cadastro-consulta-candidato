package br.com.sistemaeleicao.app;

import java.util.Scanner;

import br.com.sistemaeleicao.ui.menus.MenuPrincipal;

/**
 * Classe principal para gerenciar o cadastro de candidatos no App e inserir no banco de dados 
 * 
 * @author joaoleal
 */

public class CadastroConsultaCandidatoApp {

    public static void main(String[] args) {
        System.out.println("\nIniciando o Programa..\n");
        System.out.println("Olá, seja bem-vindo(a) ao nosso programa de consulta e cadastro de candidatos(as).");

        MenuPrincipal menuPrincipal = new MenuPrincipal();
            
        try (Scanner sc = new Scanner(System.in)){
            menuPrincipal.processarEntradas(sc);
            
        } catch (Exception e) {
            System.err.print("Um erro inesperado ao abrir o Menu Principal. Por favor tente novamente mais tarde");
            System.err.println("Tipo de erro: " + e.getMessage());
        } 

        System.out.println("\n☰☰☰  Obrigado por usar nosso sistema. Volte sempre!  ☰☰☰\n");
        System.out.println("Programa encerrado");
    }
}
