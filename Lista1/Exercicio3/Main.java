package Lista1.Exercicio3;
import java.util.Random;

public class Main {

    public static void main(String[] args) {// sem scanner pois o professor n deixou fazer precisar que usuario informe valor
    int[] vetor = new int[100000];
    Random rand = new Random();
    
    Lista1.Exercicio1.AlgoritimoDeBuscaSequencial busca = new Lista1.Exercicio1.AlgoritimoDeBuscaSequencial();
    

    for(int i = 0; i<vetor.length;i++){
        int n = rand.nextInt(10000+1);
        vetor[i] = n;
        
    }
    long tempoInicial = System.currentTimeMillis();
    int posicao = busca.buscaSequencial(10000000, vetor);
    long tempoFinal = System.currentTimeMillis();
    long tempoGasto = tempoFinal - tempoInicial;
    System.out.println("---------------");
    System.out.println("tempo gasto: "+ tempoGasto +"ms" );
    System.out.println("posicao: " + posicao);
    System.out.println("---------------");
    
    }
    
}
