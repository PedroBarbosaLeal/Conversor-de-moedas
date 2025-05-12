
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scr = new Scanner(System.in);
        Conectar conect = new Conectar();
        int chave = 0;


        do {
            try {


                System.out.println("-----------------------------------------");
                System.out.println("Seja bem-vindo(a) ao Conversor de Moeda:");
                System.out.println("1) Dólar =>> Peso argentino");
                System.out.println("2) Peso argentino =>> Dólar");
                System.out.println("3) Dólar =>> Real brasileiro");
                System.out.println("4) Real brasileiro =>> Dólar");
                System.out.println("5) Dólar =>> Peso colombiano");
                System.out.println("6) Peso colombiano =>> Dólar");
                System.out.println("7) Sair");
                System.out.println("Escolha uma opção válida:");
                System.out.println("-----------------------------");
                chave = scr.nextInt();

                switch (chave) {
                    case 1:
                        System.out.println("qual o valor a ser convetido?");
                        System.out.println("Digite:");
                        double valor = scr.nextDouble();
                        conect.conectarClient("USD", "ARS");
                        System.out.println(valor + " em $USD convertido em $ARS: " + conect.converterMoeda(valor));
                        break;

                    case 2:
                        System.out.println("qual o valor a ser convetido?");
                        System.out.println("Digite:");
                        double valor2 = scr.nextDouble();
                        conect.conectarClient("ARS", "USD");
                        System.out.println(valor2 + " em $ARS convertido em $USD: " + conect.converterMoeda(valor2));
                        break;

                    case 3:
                        System.out.println("qual o valor a ser convetido?");
                        System.out.println("Digite:");
                        double valor3 = scr.nextDouble();
                        conect.conectarClient("USD", "BRL");
                        System.out.println(valor3 + " em $USD convertido em R$BRL: " + conect.converterMoeda(valor3));
                        break;
                    case 4:
                        System.out.println("qual o valor a ser convetido?");
                        System.out.println("Digite:");
                        double valor4 = scr.nextDouble();
                        conect.conectarClient("BRL", "USD");
                        System.out.println(valor4 + " em $BRL convertido em R$USD: " + conect.converterMoeda(valor4));
                        break;
                    case 5:
                        System.out.println("qual o valor a ser convetido?");
                        System.out.println("Digite:");
                        double valor5 = scr.nextDouble();
                        conect.conectarClient("USD", "COP");
                        System.out.println(valor5 + " em $USD convertido em R$COP: " + conect.converterMoeda(valor5));
                        break;
                    case 6:
                        System.out.println("qual o valor a ser convetido?");
                        System.out.println("Digite:");
                        double valor6 = scr.nextDouble();
                        conect.conectarClient("COP", "USD");
                        System.out.println(valor6 + " em $COP convertido em R$USD: " + conect.converterMoeda(valor6));
                        break;
                    case 7:
                        System.out.println("Programa finalizado!");
                    default:
                        System.out.println("Opção invalida!");
                }
            }catch (InputMismatchException e){
                System.out.println("ERRO! digite apenas o número da opção:");
                scr.nextLine();
            }
        } while (chave != 7);

    }
}