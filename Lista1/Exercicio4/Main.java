package Lista1.Exercicio4;
import java.util.Random;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {// sem scanner pois o professor n deixou fazer precisar que usuario informe valor
        int[] vetor = new int[100000];
        Random rand = new Random();
        AlgoritmoDeBusca bundas = new AlgoritmoDeBusca();

        for(int i = 0; i<vetor.length;i++){
            int n = rand.nextInt(10000+1);
            vetor[i] = n;
            
        }
        long tempo1 = System.currentTimeMillis();
        Arrays.sort(vetor);
        long tempo2 = System.currentTimeMillis();
        long tempo3 = System.currentTimeMillis();
        int posicao = bundas.buscaBinaria(10000, vetor);
        
        long tempo4 = System.currentTimeMillis();
        long tempoDaOrdenacao = tempo2 - tempo1;
        long tempoDaBusca = tempo4 - tempo3;
        long tempoTotal = tempo4 - tempo1;
        
        System.out.println("-------------------------");
        System.out.println("Tempo da Ordenação: " + tempoDaOrdenacao +"ms" );
        System.out.println("Tempo da Busca Binária: " + tempoDaBusca + "ms");
        System.out.println("Tempo Total: " + tempoTotal + "ms");
        System.out.println("Posição no vetor: "+ posicao);
        System.out.println("-------------------------");
    }
    
}