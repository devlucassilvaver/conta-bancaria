import java.util.Random;

public class teste {

    public static void main(String[] args) {

        Random random = new Random();

        int numeroConta = random.nextInt();

        System.out.println("Número da conta gerado: " + numeroConta);
    }
}