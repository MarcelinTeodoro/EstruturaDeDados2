package Lista2.Exercicio2;

public  class QuickSort implements AlgoritimoDeOrdenaçao{
    public void ordenar(int[] vetor){
    
    quickSort(vetor, 0, vetor.length-1);
    }
    public void quickSort(int[] vetor, int ini, int fim){
        if (ini< fim) {
            int index_pivot = haroare(vetor, ini, fim);
            quickSort(vetor, ini, index_pivot -1);
            quickSort(vetor, index_pivot +1, fim);
        }
    }
    public int haroare(int[] vetor, int ini , int fim) {
        int i = ini + 1;
        int j = fim;
        int pivot = vetor[ini];
        while (i <= j) {
            while (i <= j && vetor[i] <= pivot) {
                i++;
            }
            while (i <= j && vetor[j] > pivot) {
                j= j-1;
            }
            if(i < j){
                int temp = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = temp;
            }
            
        }
        int temp = vetor[ini];
        vetor[ini] = vetor[j];
        vetor[j] = temp;
        return j;
        

    }
}
