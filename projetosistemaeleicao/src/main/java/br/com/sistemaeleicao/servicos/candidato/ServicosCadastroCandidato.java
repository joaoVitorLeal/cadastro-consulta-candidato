package br.com.sistemaeleicao.servicos.candidato;

import br.com.sistemaeleicao.modelo.Candidato;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Classe responsável por lidar com a lógica de serviço.
 * Fornece métodos para solicitar informações do usuário e criar instâncias da classe Candidato.
 * 
 * 
 * @author joaoleal
 */


public class ServicosCadastroCandidato {
    
    /* Método principal, faz a invocação dos outros métodos. */
    public static Candidato cadastrarCandidato(Scanner sc) {
        
        // Caso um campo seja nulo, o programa será encerrado
        Integer numeroRegistro = capturarNumeroRegistro(sc);
        if (numeroRegistro == null){ return null; }
        
        String nome = capturarNome(sc);
        if (nome == null){ return null; }
        
        LocalDate dataNascimento = capturarDataNascimento(sc);
        if (dataNascimento == null){ return null; }
        
        String localidade = capturarLocalidade(sc);
        if (localidade == null) { return null; }
        
        String orientacaoIdeologica = capturarOrientacaoIdeologica(sc);
        if (orientacaoIdeologica == null){ return null; }
        
        String pautas = capturarPautas(sc);
        if (pautas == null) {return null;}
        
        String cargoDesejado = capturarCargoDesejado(sc);
        if (cargoDesejado == null){ return null; }
        
        // Se todos os campos forem válidos, é retornado uma nova instancia de Candidato 
        return new Candidato(numeroRegistro, nome, dataNascimento, localidade, orientacaoIdeologica, pautas, cargoDesejado);
    }
    
    
    
    /** Segue metodos auxiliares para captura de cada campo:. */ 
    
    private static Integer capturarNumeroRegistro(Scanner sc) {
        int tentativas = 0;

        while (tentativas < 2) { // Numero maxímo de tentativas 
            System.out.println("\nInforme o número de registro do(a) candidato(a): ");
            String auxNumeroRegistro = sc.nextLine().trim(); // Variavel str auxiliar   // trim() remove espaços em branco

            // Verifica se a entrada está vazia
            if (auxNumeroRegistro.isEmpty()) {
                System.err.println("@@@  Erro: O campo 'Número de Registro' não pode ser vazio." + (tentativas == 0 ? " Tente novamente.  @@@" : " Por favor repitir a operação de cadastro.  @@@"));
                
                tentativas++; // incrementa valor de tentativa
                
            } else {
                // Tenta converter a string em Integer(numero)
                try {
                    Integer numeroRegistro = Integer.valueOf(auxNumeroRegistro);
                    return numeroRegistro;
                } catch (NumberFormatException nfe) {
                    System.err.println("@@@  Erro: Não foi possível converter o valor digitado em um número inteiro." + (tentativas == 0 ? " Tente novamente.  @@@" : " Por favor repitir a operação de cadastro.  @@@"));
                    
                    tentativas++;
                }
            }
        }
        
        return null; // Retorna nulo se não for capturado um número
    }
        
    
    private static String capturarNome(Scanner sc) {
        int tentativas = 0;
        
        while (tentativas < 2) {
            System.out.print("\nInforme o nome do(a) candidato(a): ");
            String nome = sc.nextLine().trim();

            if (nome.isEmpty()) {
                System.err.println("@@@  Erro: O campo 'Nome' não pode ser vazio." + (tentativas == 0 ? " Tente novamente.  @@@" : " Por favor repitir a operação de cadastro.  @@@"));
                
                tentativas++;
                
            } else {
                return nome;
            }
        }
        
        return null;
    }
        
        
    private static LocalDate capturarDataNascimento(Scanner sc) {
        int tentativas = 0;
        
        while (tentativas < 2) {
            System.out.println("\nInforme a data de nascimento(DD/MM/AAAA) do(a) candidato(a): ");
            String auxDataNascimento = sc.nextLine().trim();  // Variavel auxiliar para que a data de nascimento possa ser lida como uma string em formato Br (dd/MM/yyyy)
            
            if (auxDataNascimento.isEmpty()){
                System.err.println("@@@  Erro: O campo 'Data de Nascimento' não pode ser vazio." + (tentativas == 0 ? " Tente novamente.  @@@" : " Por favor repitir a operação de cadastro.  @@@"));
                
                tentativas++;
  
            } else {
                try {
                    LocalDate dataNascimento = LocalDate.parse(auxDataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                    return dataNascimento; 

                } catch (Exception e) {
                    System.err.println("@@@  Erro: Não foi possível cadastrar a Data de Nascimento com o valor/formato inserido." + (tentativas == 0 ? " Tente novamente.  @@@" : " Por favor repitir a operação de cadastro.  @@@"));
                    
                    tentativas++;
                }
            }
        }
        
        return null;
    }
    
    
    private static String capturarLocalidade(Scanner sc) {
        int tentativas = 0;
        
        while (tentativas < 2) {
            System.out.println("\nInforme o nome da cidade em que irá concorrer ao cargo: ");
            String localidade = sc.nextLine().toUpperCase();
            
            if (localidade.isEmpty()) {
                 System.err.println("@@@  Erro: O campo 'Localidade' não pode ser vazio." + (tentativas == 0 ? " Tente novamente.  @@@" : " Por favor repitir a operação de cadastro.  @@@"));
            } else {
                return localidade;
            }
        }
        
        return null;
    }
    
    
    private static String capturarOrientacaoIdeologica(Scanner sc) { 
        int tentativas = 0;
        
        while (tentativas < 2) {
            System.out.println("\nInforme a orientação ideológica(DIREITA, CENTRO, ESQUERDA) do(a) candidato(a): ");
            String orientacaoIdeologica =  sc.nextLine().trim().toUpperCase(); // Capturando e convertendo para maiúscula
             
            if (orientacaoIdeologica.isEmpty()){
                System.err.println("@@@  Erro: O campo 'Orientação Ideológica' não pode ser vazio." + (tentativas == 0 ? " Tente novamente.  @@@" : " Por favor repitir a operação de cadastro.  @@@"));
                
                tentativas++;                
            } else {
                return orientacaoIdeologica;
            }
        }
        
        return null;
    }
     
    
    private static String capturarPautas(Scanner sc) {
        int tentativas = 0;
        
        while(tentativas < 2) {
            System.out.println("\nAgora, por favor, descreva suas pautas e seu planejamento de gestão.\nInclua detalhes sobre suas propostas e como pretende concretizá-las: ");
            String pautas = sc.nextLine().trim();
            
            if (pautas.isEmpty()) {
                System.err.println("@@@  Erro: O campo 'pautas' não pode ser vazio." + (tentativas == 0 ? " Tente novamente.  @@@" : " Por favor repitir a operação de cadastro.  @@@"));
            } else {
                return pautas;
            }
        }
        
        return null;
    }
        
       
        
    private static String capturarCargoDesejado(Scanner sc) {
        int tentativas = 0;
        
        while (tentativas < 2) {
            System.out.println("\nInforme o cargo almejado do(a) candidato(a): ");
            String cargoDesejado = sc.nextLine().trim().toUpperCase();
            
            if (cargoDesejado.isEmpty()) {
                System.err.println("@@@  Erro: O campo 'cargo almejado' não pode ser vazio." + (tentativas == 0 ? " Tente novamente.  @@@" : " Por favor repitir a operação de cadastro.  @@@"));
                
                tentativas++;
            } else {            
            return cargoDesejado;
            }
        }    
        
        return null;
    }        
}
