package Lista2.Exercicio5;

public class QuickSortDualPivot  {
    public void ordenar(int[] vetor) {
        quickSort(vetor, 0, vetor.length - 1);
    }

    private void quickSort(int[] vetor, int ini, int fim) {
        if (ini < fim) {
            
            int[] pivots = partition(vetor, ini, fim);
            int p1 = pivots[0];
            int p2 = pivots[1];

            
            quickSort(vetor, ini, p1 - 1);
            quickSort(vetor, p1 + 1, p2 - 1);
            quickSort(vetor, p2 + 1, fim);
        }
    }

    private int[] partition(int[] vetor, int ini, int fim) {
        
        if (vetor[ini] > vetor[fim]) {
            swap(vetor, ini, fim);
        }
        int p1 = vetor[ini];
        int p2 = vetor[fim];

        
        int lt = ini + 1; 
        int gt = fim - 1; 
        int i = ini + 1;  

        while (i <= gt) {
            if (vetor[i] < p1) {
                swap(vetor, i, lt);
                lt++;
            } else if (vetor[i] > p2) {
                swap(vetor, i, gt);
                gt--;
                i--; 
            }
            i++;
        }

        
        swap(vetor, ini, --lt);
        swap(vetor, fim, ++gt);

        
        return new int[]{lt, gt};
    }

    private void swap(int[] vetor, int i, int j) {
        int temp = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = temp;
    }
}
