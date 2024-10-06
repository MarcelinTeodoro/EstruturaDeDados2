package Lista1.Exercicio2;
import java.util.ArrayList;;

public class AlgoritimoDebuscaSequencial {
    public ArrayList<Integer> buscaSequencial(int chaveBusca , int []vetor){
        ArrayList<Integer> posicoes = new ArrayList<>();
        
        for(int i = 0; i< vetor.length;i++){
            if(vetor[i]== chaveBusca){
                posicoes.add(i);
            }
            }
        return posicoes;
        
    }
}
