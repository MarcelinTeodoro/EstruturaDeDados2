package Lista1.Exercicio4;

public class AlgoritmoDeBusca {
    public  int buscaBinaria(int chaveBusca , int []vetor){
        
        int posInicial= 0;
        int posFinal = vetor.length -1;
        while (posInicial <= posFinal) {
            int posicaoMeio = (posInicial+posFinal)/2;
            if(vetor[posicaoMeio]== chaveBusca){
                
                return posicaoMeio;
                
                
            }
            else if(chaveBusca < vetor[posicaoMeio])posFinal = posicaoMeio -1;
            else if(chaveBusca > vetor[posicaoMeio])posInicial = posicaoMeio +1;

        }
        return -1;
    }
}
