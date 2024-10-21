package Lista2.Exercicio4;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int [] vetor = new int[100000];
        BubbleSortMelhorado bolha = new BubbleSortMelhorado();
        System.out.println("---------------------------");
        for(int i = 0; i < vetor.length ; i++ ){
            geraVetor(vetor);
        
        
            long tempo1 = System.currentTimeMillis();
            bolha.bubbleSortMelhorado(vetor);
            long tempo2 = System.currentTimeMillis();
            long tempoTotal= tempo2 - tempo1;
            System.out.println("Bubble Sort : "+ tempoTotal);

        }
        System.out.println("---------------------------");
        
        


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
