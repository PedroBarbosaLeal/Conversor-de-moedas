
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scr = new Scanner(System.in);
        System.out.println("Digite a moeda que você quer procurar");
        String moeda = scr.nextLine();
        System.out.println("Digite a moeda 2");


        Conectar conect = new Conectar();

        conect.conectarClient(moeda);

    }
}