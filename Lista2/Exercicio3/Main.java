package Lista2.Exercicio3;
import java.util.Scanner;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList lista = new ArrayList<>();
        int a = scanner.nextInt();

        while (a !=0) {

            a = scanner.nextInt();
            lista.add(a);
            
        }

    }
}
