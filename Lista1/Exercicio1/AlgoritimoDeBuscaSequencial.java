package Lista1.Exercicio1;

public class AlgoritimoDeBuscaSequencial {
    
    public  int buscaSequencial(int chaveBusca , int [] vetor){
        int i = 0;
        while( i < vetor.length ) {
            if (vetor[i] == chaveBusca) {
                return i;
            }
            i++;
        }
        
        return -1;
    }
}