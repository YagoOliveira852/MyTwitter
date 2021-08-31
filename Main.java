import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Escolha a opção desejada:\n 1) Testa BancoVector\n 2) Testa BancoArray");
    int opcao = scanner.nextInt();
    switch(opcao) {
      case 1: ;
      System.out.println("Hello World!");
              break;
              
      case 2: ;
      System.out.println("Hello World!");
              break;
              
      default: System.out.println("Opção inexistente!");
              break;
    }
    scanner.close();
  }
  
}