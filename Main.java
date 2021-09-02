import java.util.Scanner;

import Perfis.Perfil;
import Perfis.PessoaFisica;
import Perfis.PessoaJuridica;
import Perfis.Exceptions.PEException;
import repositorio.RepositorioVector;
import twitter.MyTwitter;
import twitter.Tweet;



class Main {

  private static Scanner entrada = new Scanner(System.in);

  public static void funcoes() {
    System.out.println("----------------------------------------------------");
    System.out.println("               Bem vindo ao MyTwitter    \n");
    System.out.println("1 - Cadastrar conta \n");
    System.out.println("2 - Cancelar conta \n");
    System.out.println("3 - Reativar conta \n");
    System.out.println("4 - tweetar \n");
    System.out.println("5 - Acessar timeline \n");
    System.out.println("6 - Visualizar seus tweets \n");
    System.out.println("7 - Seguir \n");
    System.out.println("8 - Visualizar número de seguidores \n");
    System.out.println("9 - Visualizar seguidores \n");
    System.out.println("10 - Visualizar seguidos \n");
    System.out.println("0 - Fechar o MyTwitter \n");
    System.out.println("----------------------------------------------------");
  }

  public static void main(String[] args) { 
    RepositorioVector repositorio = new RepositorioVector();
    MyTwitter mytwitter = new MyTwitter(repositorio);
    Perfil conta;
    String usuario;
    String usuarioaux;
    String mensagem;
    int opcao = 100;
    
    while(opcao != 0){
      System.out.println("\n\n\n");
      System.out.println("Selecione a opção desejada:");
      funcoes();
      opcao = entrada.nextInt();

      switch(opcao){
        case 1:
          
          int ContaTipo= 100;
          System.out.println("Selecione a opção desejada: \n");
          System.out.println("1 - Conta para Pessoa Física \n");
          System.out.println("2 - Conta para Pessoa Jurídica \n");
          ContaTipo = entrada.nextInt();

          switch(ContaTipo){   
            case 1:    
              System.out.println("Digite o CPF: \n");
              long cpf = entrada.nextLong();
              System.out.println("Digite o nome de usuário: \n");
              usuario = entrada.next();
              conta = new PessoaFisica(usuario, cpf);
              try{
                mytwitter.criarPerfil(conta);
              }
              catch (PEException pee) {
                System.out.println(pee.GetMessage());
              }
            break;

            case 2:
              System.out.println("Digite o CNPJ: ");
              long cnpj = entrada.nextLong();
              
              System.out.println("Digite o nome de usuário: \n");
              usuario = entrada.next();
              conta = new PessoaJuridica(usuario, cnpj);
              try{
                mytwitter.criarPerfil(conta);
              }
              catch (PEException pee) {
                System.out.println(pee.GetMessage());
              }
            break;
          
            default:
              System.out.println("Opção inexistente!!");
            break;
                            
          }    
        break;

        case 2:
          System.out.println("Digite o nome de usuário:");
          usuario = entrada.next();

          try {
            mytwitter.cancelarPerfil(usuario);
          } 
          catch (Exception e) {
            System.out.println(e.getMessage());
          }
        break;

        case 3:
          System.out.println("Digite o nome de usuário:");
          usuario = entrada.next();

          try {
            mytwitter.reativarPerfil(usuario);
          } 
          catch (Exception e) {
            System.out.println(e.getMessage());
          }
        break;

        case 4:
          System.out.println("Digite o nome de usuário:");
          usuario = entrada.next();
          System.out.println("Digite a mensagem a ser tweetada:");
          mensagem = entrada.next();

          try {
            mytwitter.tweetar(usuario, mensagem);
          } 
          catch (Exception e) {
            System.out.println(e.getMessage());
          }
        break;   

        case 5:
          System.out.println("Digite o nome de usuário:");
          usuario = entrada.next();

          try {
            for(Tweet tweet : mytwitter.timeline(usuario)){
              System.out.println("\nO usuário @"+ tweet.getUsario() + " publicou: \n" +tweet.getMensagem());
            }
          } 
          catch (Exception e) {
            System.out.println(e.getMessage());
          }
        break;

        case 6:
          System.out.println("Digite o nome de usuário:");
          usuario = entrada.next();

          try {
            for(Tweet tweet : mytwitter.tweets(usuario)){
              System.out.println("\nO usuário @"+ tweet.getUsario() + " publicou: \n" +tweet.getMensagem());
            }
          } 
          catch (Exception e) {
            System.out.println(e.getMessage());
          }
        break;

        case 7:
          System.out.println("Digite o seu nome de usuário:");
          usuario = entrada.next();
          System.out.println("Digite o nome de usuário de quem deseja seguir:");
          usuarioaux = entrada.next();

          try {
            mytwitter.seguir(usuario, usuarioaux);
            System.out.println("Usuário seguido com sucesso");
          } 
          catch (Exception e) {
            System.out.println(e.getMessage());
          }
        break;

        case 8:
          int quantidade;
          System.out.println("Digite o nome de usuário:");
          usuario = entrada.next();

          try {
            quantidade = mytwitter.numeroSeguidores(usuario);
            System.out.println("O número de seguidores: \n" + quantidade);
          } 
          catch (Exception e) {
            System.out.println(e.getMessage());
          }
        break;

        case 9:
          System.out.println("Digite o nome de usuário:");
          usuario = entrada.next();

          try {
            System.out.println("Os seguidores: \n");
            for(Perfil perfil : mytwitter.seguidores(usuario)){
              System.out.println("@"+perfil.getUsuario());
            }
          } 
          catch (Exception e) {
            System.out.println(e.getMessage());
          }
        break;

        case 10:
          System.out.println("Digite o nome de usuário:");
          usuario = entrada.next();

          try {
            System.out.println("Os seguidos: \n");
            for(Perfil perfil : mytwitter.seguidos(usuario)){
              System.out.println("@"+perfil.getUsuario());
            }
          } 
          catch (Exception e) {
            System.out.println(e.getMessage());
          }
        break;

        case 0:
          System.out.println("Obrigado por usar o mytwitter!!");
          System.exit(0);
        break;

        default: 
          System.out.println("Opção inexistente!");
          break;
      }

    }
    
  }

}