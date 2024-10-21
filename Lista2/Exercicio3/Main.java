package Lista2.Exercicio3;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite números para inserir na lista ordenada (digite -1 para encerrar):");

        while (true) {
            int numero = scanner.nextInt();

            if (numero == -1) {
                break; 
            }

            
            int posicao = 0;
            while (posicao < lista.size() && lista.get(posicao) < numero) {
                posicao++;
            }
            lista.add(posicao, numero);

            System.out.println("Lista atual: " + lista);
        }

        scanner.close();
        System.out.println("Lista final ordenada: " + lista);
    }
}
