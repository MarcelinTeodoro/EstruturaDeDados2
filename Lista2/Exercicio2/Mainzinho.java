package Lista2.Exercicio2;

import java.util.Random;

public class Mainzinho {
    public static void main(String[] args) {
        
        int[] vetor = new int[100000];
        
        for(int i = 0; i< 10; i++){
            tabela(vetor);
        }
        



    }
    public static void tabela(int[] vetor){
        
        AlgoritimoDeOrdenaçao  bubble = new BubbleSort();
        int[] vetorTeste = geraVetor(vetor);
        System.out.println("------------TABELA DE TEMPO DE EXECUÇÃO------------");
        long tempo1 = System.currentTimeMillis();
        bubble.ordenar(vetorTeste);
        long tempo2 = System.currentTimeMillis();
        long tempoTotal= tempo2 - tempo1;
        System.out.println("Bubble Sort : "+ tempoTotal);

        
        vetorTeste = geraVetor(vetor);
        AlgoritimoDeOrdenaçao insetion = new InsertionSort();
        tempo1 = System.currentTimeMillis();
        insetion.ordenar(vetorTeste);
        tempo2 = System.currentTimeMillis();
        tempoTotal= tempo2 - tempo1;
        System.out.println("Insertion Sort : "+ tempoTotal);

        
        vetorTeste = geraVetor(vetor);
        AlgoritimoDeOrdenaçao selection = new SelectionSort();
        tempo1 = System.currentTimeMillis();
        selection.ordenar(vetorTeste);
        tempo2 = System.currentTimeMillis();
        tempoTotal= tempo2 - tempo1;
        System.out.println("Selection Sort : "+ tempoTotal);

        
        vetorTeste = geraVetor(vetor);
        AlgoritimoDeOrdenaçao shell = new ShellSort();
        tempo1 = System.currentTimeMillis();
        shell.ordenar(vetorTeste);
        tempo2 = System.currentTimeMillis();
        tempoTotal= tempo2 - tempo1;
        System.out.println("Shell Sort : "+ tempoTotal);

        
        vetorTeste = geraVetor(vetor);
        AlgoritimoDeOrdenaçao merge = new MergeSort();
        tempo1 = System.currentTimeMillis();
        merge.ordenar(vetorTeste);
        tempo2 = System.currentTimeMillis();
        tempoTotal= tempo2 - tempo1;
        System.out.println("Merge Sort : "+ tempoTotal);

        
        vetorTeste = geraVetor(vetor);
        AlgoritimoDeOrdenaçao quick = new QuickSort();
        tempo1 = System.currentTimeMillis();
        quick.ordenar(vetorTeste);
        tempo2 = System.currentTimeMillis();
        tempoTotal= tempo2 - tempo1;
        System.out.println("Quick Sort: "+tempoTotal);
        System.out.println("--------------------------------");

        
    }
    public static int[] geraVetor(int[] vetor){
        Random rand = new Random();
        for(int i = 0; i<vetor.length;i++){
            int n = rand.nextInt(100000+1);
            vetor[i] = n;
            
        }


        return vetor;
    }
}
