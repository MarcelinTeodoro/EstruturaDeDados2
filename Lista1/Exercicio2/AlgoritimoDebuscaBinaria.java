package Lista1.Exercicio2;
import java.util.ArrayList;
public class AlgoritimoDebuscaBinaria {
    public static void main(String[] args) {
        int[] vetor = new int[10];
        vetor[0] = 1;
        vetor[1] = 4;
        vetor[2] = 4;
        vetor[3] = 4;
        vetor[4] = 4;
        vetor[5] = 4;
        vetor[6] = 5;
        vetor[7] = 5;
        vetor[8] = 7;
        vetor[9] =  10;

        
        System.out.println(buscaBinaria(4, vetor));
        System.out.println(buscaBinaria(10, vetor));
        System.out.println(buscaBinaria(1, vetor));
    } 
    
    public static ArrayList<Integer> buscaBinaria(int chaveBusca , int []vetor){
        ArrayList<Integer> posicoes = new ArrayList<>();
        int posInicial= 0;
        int posFinal = vetor.length -1;
        while (posInicial <= posFinal) {
            int posicaoMeio = (posInicial+posFinal)/2;
            if(vetor[posicaoMeio]== chaveBusca){
                
                int j = posicaoMeio;
                while ( j < vetor.length && vetor[j]== chaveBusca  )  {
                    posicoes.add(j);
                    j++;
                }
                j = posicaoMeio -1 ;
                while ( j >= 0 && vetor[j]== chaveBusca) { 
                    posicoes.add(j);
                    j--;
                }
                return posicoes;
            }
            else if(chaveBusca < vetor[posicaoMeio])posFinal = posicaoMeio -1;
            else if(chaveBusca > vetor[posicaoMeio])posInicial = posicaoMeio +1;

        }
        return posicoes;
    }
}
