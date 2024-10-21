package Lista2.Exercicio4;



/**
 * BubbleSortMelhorado
 */
public class BubbleSortMelhorado {
    
    public static void main(String[] args) {
        int [] vzin = {1,2,3,4,5} ;
        bubbleSortMelhorado(vzin);
        for(int i = 0; i < vzin.length ; i++ ){
            System.out.print(vzin[i]+" ");
        }
    }

    public static void bubbleSortMelhorado(int[] vetor){
        
        for(int i = 0; i < vetor.length -1 ; i++){
            int qtdTroca = 0;
            for(int j = 0; j < vetor.length - i - 1; j++){
                if (vetor[j]>vetor[j+1]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[j+1];
                    vetor[j+1] = temp;
                    qtdTroca++;
                }
            }
            if (qtdTroca == 0) {
                System.out.println("esta ordenado");
                return ;
            }
        }
        
    }
}