package Lista2.Exercicio3;
import java.util.ArrayList;
/**
 * InsertionSort
 */
public class InsertionSort {

    public void ordenar(ArrayList vetor){
        for(int i = 1; i< vetor.size();i++){
            int elemento = vetor.;
            int j = i-1;
            while (j >= 0 && vetor[j] > elemento) {
                vetor[j+1] = vetor[j];
                j--;
            }
            vetor[j+1] = elemento;
        }
    }
}