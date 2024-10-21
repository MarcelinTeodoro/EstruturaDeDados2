package Lista2.Exercicio5;



import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] vetor = new int[100000];

        for (int i = 0; i < 10; i++) {
            executarTeste(vetor);
        }
    }

    public static void executarTeste(int[] vetor) {
        
        geraVetorAleatorio(vetor);
        QuickSortDualPivot quickSortDualPivot = new QuickSortDualPivot();

        System.out.println("------------TABELA DE TEMPO DE EXECUÇÃO------------");
        long tempoInicio = System.currentTimeMillis();
        quickSortDualPivot.ordenar(vetor);
        long tempoFim = System.currentTimeMillis();
        long tempoTotal = tempoFim - tempoInicio;
        System.out.println("QuickSort Dual-Pivot: " + tempoTotal + " ms");
        System.out.println("--------------------------------");
    }

    public static void geraVetorAleatorio(int[] vetor) {
        Random rand = new Random();
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = rand.nextInt(100000 + 1);
        }
    }
}

