package Lista2.Exercicio3;
import java.util.ArrayList;
/**
 * InsertionSort
 */
public class InsertionSort {




    public void ordenar(ArrayList<Integer> vetor) {
        for (int i = 1; i < vetor.size(); i++) {
            int elemento = vetor.get(i);
            int j = i - 1;

            
            while (j >= 0 && vetor.get(j) > elemento) {
                vetor.set(j + 1, vetor.get(j)); 
                j--;
            }

            
            vetor.set(j + 1, elemento);
        }
    }
}

