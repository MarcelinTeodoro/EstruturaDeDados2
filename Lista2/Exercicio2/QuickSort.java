package Lista2.Exercicio2;

public  class QuickSort implements AlgoritimoDeOrdenaçao{
    public void ordenar(int[] vetor){
    
    
    }
    public void haroare(String[] args) {
        int i = ini + 1;
        int j = fim;
        int pivot = vetor[ini];

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
}
